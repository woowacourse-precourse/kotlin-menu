package menu.service

import menu.strings.ErrorMessage

object ExceptionHandler {
    fun isValidNameLength(coachName: String): Boolean {
        val names = coachName.split(",")
        for (name in names) {
            try {
                require(name.length in 2..4) { ErrorMessage.COACH_NAME }
            } catch (e: IllegalArgumentException) {
                println(e.message)
                return false
            }
        }
        return true
    }

    fun isValidNumber(count: Int): Boolean {
        try {
            require(count in 2..5) { ErrorMessage.COACH_NUMBER }
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return false
        }
        return true
    }

    fun isValidUnavailableFoods(count: Int): Boolean {
        try {
            require(count in 0..2) { ErrorMessage.UNAVAILABLE_NUMBER }
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return false
        }
        return true
    }
}