package menu

object Validator {

    fun isValidCoachInput(userInput: String): Boolean {
        if (!isValidMember(userInput)) {
            return false
        }

        return true
    }

    fun isValidLetter(userInput: String): Boolean {
        return true
    }

    fun isValidDivision(userInput: String): Boolean {
        return true
    }

    fun isValidMember(userInput: String): Boolean {
        val count =  userInput.split(',').size
        if (count !in 2..5) {
            return false
        }
        return true
    }


}