package menu.validator

import menu.util.Util

class CoachValidator {
    fun checkInput(input: String) {
        if (checkInputOverNumberScope(input) || checkNameIsOverSize(input)) {
            require(false)
        }
    }

    private fun checkInputOverNumberScope(input: String): Boolean {
        val inputSize = Util().convertCommaStringToList(input).size
        if (inputSize < 2 || inputSize > 5) {
            return true
        }
        return false
    }

    private fun checkNameIsOverSize(input: String): Boolean {
        val coachList = Util().convertCommaStringToList(input)
        for (coach in coachList) {
            if (coach.length < 2 || coach.length > 4) {
                return true
            }
        }
        return false
    }
}