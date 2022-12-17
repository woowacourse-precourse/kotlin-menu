package menu

object Validator {

    fun isValidCoachInput(userInput: String): Boolean {
        if (!isInputBlank(userInput)) {
            return false
        }
        val coaches  = userInput.split(',')

        if (!isValidMember(coaches)) {
            return false
        }

        if (!isValidLetter(coaches)) {
            return false
        }

        return true
    }

    fun isInputBlank(userInput: String): Boolean {
        if (userInput.isNullOrBlank()) return false
        return true
    }


    fun isValidLetter(coachs: List<String>): Boolean {
        for (c in coachs) {
            if (c.length !in 2.. 4) {
                return false
            }
        }
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