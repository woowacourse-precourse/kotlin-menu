package menu.validator

import menu.constant.Constant
import menu.util.Util

class CoachValidator {
    fun checkInput(input: String) {
        if (checkInputOverNumberScope(input) || checkNameIsOverSize(input)) {
            require(false)
        }
    }

    private fun checkInputOverNumberScope(input: String): Boolean {
        val inputSize = Util().convertCommaStringToList(input).size
        if (inputSize < Constant.COACH_MEMBER_MIN_NUM || inputSize > Constant.COACH_MEMBER_MAX_NUM) {
            return true
        }
        return false
    }

    private fun checkNameIsOverSize(input: String): Boolean {
        val coachList = Util().convertCommaStringToList(input)
        for (coach in coachList) {
            if (coach.length < Constant.COACH_NAME_MIN_SIZE || coach.length > Constant.COACH_NAME_MAX_SIZE) {
                return true
            }
        }
        return false
    }
}