package menu

object Validator {

    fun isValidCoachInput(userInput: String): Boolean {
        if (!isInputBlank(userInput)) {
            return false
        }
        val coachs = userInput.split(',')

        if (!isValidMember(coachs)) {
            return false
        }

        if (!isValidLetter(coachs)) {
            return false
        }

        return true
    }

    fun isInputBlank(userInput: String): Boolean {
        if (userInput.isNullOrBlank()) return false
        return true
    }


    fun isValidLetter(coachs: List<String>): Boolean {
        return true
    }

    fun isValidMember(coachs: List<String>): Boolean {
        val count =  coachs.size
        if (count !in 2..5) {
            return false
        }
        return true
    }


}