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
}