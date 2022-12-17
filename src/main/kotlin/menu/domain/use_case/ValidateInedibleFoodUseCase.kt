package menu.domain.use_case

import menu.data.Error
import menu.data.ErrorState
import menu.data.ErrorState.isOkFoodsInMenus
import menu.data.Menu.allFoods
import menu.data.State
import menu.data.State.coachNames
import menu.ui.Views
import java.lang.IllegalArgumentException

class ValidateInedibleFoodUseCase(
    private val views: Views = Views(),
) {
    operator fun invoke() {
        do {
            saveInedibleFoods()
        } while (!isOkFoodsInMenus)
    }

    private var isPossibleToInputNextCoach = false

    private fun saveInedibleFoods() {
        coachNames.forEach { coachName ->
            isPossibleToInputNextCoach = false
            isOkFoodsInMenus = false
            do {
                val notSeparatedInedibleFoods = views.inputView.readInedibleFoodName(coachName)
                val inedibleFoods = separatedInedibleFoods(notSeparatedInedibleFoods)
                validateFoodsInMenus(inedibleFoods)
                validateFoodSize(inedibleFoods)
                State.inedibleFoods[coachName] = inedibleFoods
                // TODO save하는 객체 따로 생성!
            } while (!isPossibleToInputNextCoach || !isOkFoodsInMenus)
        }
    }

    private fun List<String>.isValidFoodsInMenus(): Boolean {
        return this.all { allFoods.contains(it) }
    }

    private fun validateFoodsInMenus(foods: List<String>) {
        if (foods[0].isNotEmpty()) {
            try {
                isOkFoodsInMenus = true
                isPossibleToInputNextCoach = true
                require(foods.isValidFoodsInMenus())
            } catch (exception: IllegalArgumentException) {
                isOkFoodsInMenus = false
                isPossibleToInputNextCoach = false
                views.outputView.printError(Error.NameLengthError(message = Error.ERROR_HEADER + Error.ERROR_FOOD_NOT_IN_MENUS))
            }
        } else {
            isOkFoodsInMenus = true
            isPossibleToInputNextCoach = true
        }
    }

    private fun List<String>.isValidFoodSize(): Boolean {
        return this.size in INEDIBLE_FOOD_MIN_COUNT + 1..COACH_NAME_MAX_LENGTH
    }

    private fun validateFoodSize(foods: List<String>) {
        try {
            isPossibleToInputNextCoach = true
            require(foods.isValidFoodSize())
        } catch (exception: IllegalArgumentException) {
            isPossibleToInputNextCoach = false
            views.outputView.printError(Error.NameLengthError(message = Error.ERROR_HEADER + Error.ERROR_FOOD_SIZE))
        }
    }

    private fun separatedInedibleFoods(foods: String): List<String> {
        return foods.split(",")
    }

    companion object {
        const val INEDIBLE_FOOD_MIN_COUNT = 0
        const val COACH_NAME_MAX_LENGTH = 2
    }
}