package menu.util

import com.sun.tools.jconsole.JConsoleContext.ConnectionState

class Validator {

    fun checkCoachesInput(input : String) {
        checkCoachesSizeValid(input)
        input.split(",").forEach {
            checkNameValid(input)
            checkNameSizeValid(input)
        }
    }

    fun checkNameValid(input : String) {
        require(input.matches("^[가-힣]*$".toRegex())) { Constants.NAME_VALUE_ERROR }
    }

    fun checkNameSizeValid(input: String) {
        require(input.length in Constants.COACH_NAME_MIN_SIZE..Constants.COACH_NAME_MAX_SIZE) { Constants.COACH_NAME_SIZE_ERROR }
    }

    fun checkCoachesSizeValid(input : String) {
        require(input.split(",").size in Constants.COACHES_MIN_SIZE..Constants.COACHES_MAX_SIZE) {
            Constants.COACHES_SIZE_ERROR
        }
    }

    fun checkFoodsSizeValid(input : String) {
        require(input.split(",").size in Constants.FOODS_MIN_SIZE..Constants.FOODS_MAX_SIZE) { Constants.FOODS_SIZE_ERROR }
    }
}