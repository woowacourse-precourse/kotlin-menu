package menu

import menu.view.OutputView

class Validator {
    fun validateCoachName(name: List<String>) {
        if (!(checkCoachNum(name) && checkCoachNameSize(name))) {
            OutputView().printErrorMessage(ERROR_COACH)
            throw IllegalArgumentException()
        }
    }

    private fun checkCoachNum(coach: List<String>): Boolean {
        if (coach.size in 2..5)
            return true
        return false
    }

    private fun checkCoachNameSize(names: List<String>): Boolean {
        for (name in names) {
            if (name.length < 2 || name.length > 4)
                return false
        }
        return true
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
        for (menu in Food.values())
            if (menu.menu.contains(food))
                check = true
        if (!check) {
            OutputView().printErrorMessage(ERROR_FOOD_NOT_IN_MENU)
            throw IllegalArgumentException()
        }
    }
}