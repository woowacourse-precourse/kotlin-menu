package menu.utils

import menu.utils.Constant.COACH_NAME_INPUT_TYPE_ERROR_MESSAGE

object Exception {
    fun String.coachNameInputException() {
        try {
            this.trim().split(",").forEach{
                if (it.length !in 2..4) throw IllegalArgumentException(COACH_NAME_INPUT_TYPE_ERROR_MESSAGE)
            }
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException(COACH_NAME_INPUT_TYPE_ERROR_MESSAGE)
        }
    }
}