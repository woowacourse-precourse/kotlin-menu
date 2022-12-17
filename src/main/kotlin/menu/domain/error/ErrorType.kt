package menu.domain.error

import menu.domain.resource.*

enum class ErrorType(
    private val message: String
) {
    NUMBER_OF_COACH(ERROR_FORMAT.format(ERROR_NUMBER_OF_COACH)),
    LENGTH_OF_NAME(ERROR_FORMAT.format(ERROR_COACH_NAME)),
    NUMBER_OF_MENU(ERROR_FORMAT.format(ERROR_NUMBER_OF_MENU));

    companion object {
        fun makeError(error: ErrorType) {
            throw IllegalArgumentException(error.message)
        }
    }
}