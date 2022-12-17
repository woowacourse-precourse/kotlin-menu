package menu.validator

import menu.util.Util

class HateFoodValidator {
    fun checkInput(input: String) {
        if (checkInputSize(input)) {
            require(false)
        }
    }

    private fun checkInputSize(input : String) : Boolean {
        val inputSize = Util().convertCommaStringToList(input).size
        if (inputSize < 0 || inputSize > 2) {
            return true
        }
        return false
    }
}