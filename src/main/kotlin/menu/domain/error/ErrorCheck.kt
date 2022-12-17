package menu.domain.error

import menu.domain.error.ErrorType.Companion.makeError
import menu.domain.resource.*

object ErrorCheck {
    fun checkValidCoachName(value: String?) {
        val names = value!!.split(SEPARATOR)

        checkNumberOfName(names)
        names.forEach { n -> checkLengthOfName(n) }
    }

    fun checkNumberOfName(value: List<String>) {
        if (value.size < MIN_COACH_NUM || value.size > MAX_COACH_NUM) {
            makeError(ErrorType.NUMBER_OF_COACH)
        }
    }

    fun checkLengthOfName(value: String) {
        if (value.trim().length < MIN_COACH_NAME || value.trim().length > MAX_COACH_NAME) {
            makeError(ErrorType.LENGTH_OF_NAME)
        }
    }

    fun checkValidMenu(value: String) {
        val menus = value.split(SEPARATOR)

        checkNumberOfMenu(menus)
    }

    fun checkNumberOfMenu(value: List<String>) {
        if (value.size < MIN_MENU_CANT_EAT || value.size > MAX_MENU_CANT_EAT) {
            makeError(ErrorType.NUMBER_OF_MENU)
        }
    }
}