package menu

import menu.view.OutputView

class Validator {
    fun validateCoachName(name: List<String>) {
        checkCoachNum(name)
        checkCoachNameSize(name)
    }

    private fun checkCoachNum(coach: List<String>) {
        if (coach.size !in 2..5) {
            OutputView().printErrorMessage(ERROR_COACH_NUM)
            throw IllegalArgumentException()
        }
    }

    private fun checkCoachNameSize(names: List<String>) {
        for (name in names) {
            if (name.length < 2 || name.length > 4) {
                OutputView().printErrorMessage(ERROR_COACH_NAME_NUM)
                throw IllegalArgumentException()
            }
        }
    }

    fun validateFood(food: List<String>) {
        checkFoodSize(food)
        for (cantEat in food)
            checkFoodIsExistInMenu(cantEat)
    }

    private fun checkFoodSize(food: List<String>) {
        if (food.size > 2) {
            OutputView().printErrorMessage(ERROR_FOOD_SIZE)
            throw IllegalArgumentException()
        }
    }

    private fun checkFoodIsExistInMenu(food: String) {
        var check = false
        if (food == "")
            check = true
        for (menu in Food.values())
            if (menu.menu.contains(food))
                check = true
        if (!check) {
            OutputView().printErrorMessage(ERROR_FOOD_NOT_IN_MENU)
            throw IllegalArgumentException()
        }
    }
}