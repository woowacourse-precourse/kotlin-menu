package menu.util

class Validator {

    fun checkNameValid(input : String) {
        require(input.matches("^[가-힣]*$".toRegex())) { Constants.NAME_VALUE_ERROR }
    }
}