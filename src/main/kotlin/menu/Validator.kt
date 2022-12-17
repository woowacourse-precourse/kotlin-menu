package menu

object Validator {

    private const val MIN_COACH_NAME = 2
    private const val MAX_COACH_NAME = 4
    private const val MIN_COACH_COUNT = 2
    private const val MAX_COACH_COUNT = 5


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

    private fun isInputBlank(userInput: String): Boolean {
        if (userInput.isNullOrBlank()) return false
        return true
    }

    private fun isValidLetter(coachs: List<String>): Boolean {
        for (c in coachs) {
            if (c.length !in MIN_COACH_NAME.. MAX_COACH_NAME) {
                return false
            }
        }
        return true
    }

    private fun isValidMember(coachs: List<String>): Boolean {
        val count =  coachs.size
        if (count !in MIN_COACH_COUNT..MAX_COACH_COUNT) {
            return false
        }
        return true
    }


}