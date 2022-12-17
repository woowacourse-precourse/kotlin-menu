package menu.validator

import menu.constant.Constant
import menu.util.Util

class HateFoodValidator {
    fun checkInput(input: String) {
        if (checkInputSize(input)) {
            require(false)
        }
    }

    private fun checkInputSize(input : String) : Boolean {
        val inputSize = Util().convertCommaStringToList(input).size
        if (inputSize < Constant.HATE_FOOD_LIST_MIN_SIZE || inputSize > Constant.HATE_FOOD_LIST_MAX_SIZE) {
            return true
        }
        return false
    }
}