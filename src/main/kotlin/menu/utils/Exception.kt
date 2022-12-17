package menu.utils

import menu.utils.Constant.COACH_NAME_INPUT_TYPE_ERROR_MESSAGE
import menu.utils.Constant.COACH_PERSONNEL_INPUT_TYPE_ERROR_MESSAGE

object Exception {
    fun String.coachNameInputException() {
        try {
            this.trim().split(",").forEach {
                if (it.length !in 2..4) throw IllegalArgumentException(COACH_NAME_INPUT_TYPE_ERROR_MESSAGE)
            }
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException(COACH_NAME_INPUT_TYPE_ERROR_MESSAGE)
        }
    }

    fun String.coachPersonnelInputException() {
        try {
            if (this.trim()
                    .split(",").size < 2
            ) throw IllegalArgumentException(COACH_PERSONNEL_INPUT_TYPE_ERROR_MESSAGE)
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException(COACH_PERSONNEL_INPUT_TYPE_ERROR_MESSAGE)
        }
    }
}