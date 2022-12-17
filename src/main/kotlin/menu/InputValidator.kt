package menu

import java.lang.IllegalArgumentException

object InputValidator {
    fun coachNames(input: String) {
        val names = input.split(",").map { it.trim() }
        if (names.size < 2 || names.size > 5) throwError(Error.ERROR_COACH_PERSON_NUM_WRONG)
        names.forEach {
            if (it.length < 2 || it.length > 4) throwError(Error.ERROR_COACH_NAME_WRONG)
        }
    }

    fun hateMenu(input: String) {
        val menus = input.split(",").map { it.trim() }
        if (menus.isEmpty()) return // 빈 것은 괜찮음. 못 먹는 음식이 없다는 의미.
        if (menus.size > 2) throwError(Error.ERROR_HATE_MENU_MAX_TWO)
    }

    private fun throwError(error: Error) {
        throw IllegalArgumentException(error.message)
    }
}