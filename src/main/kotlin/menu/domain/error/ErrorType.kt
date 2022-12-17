package menu.domain.error

import menu.domain.resource.ERROR_COACH_NAME
import menu.domain.resource.ERROR_FORMAT
import menu.domain.resource.ERROR_NUMBER_OF_COACH

enum class ErrorType(
    private val message: String
) {
    NUMBER_OF_COACH(ERROR_FORMAT.format(ERROR_NUMBER_OF_COACH)),
    LENGTH_OF_NAME(ERROR_FORMAT.format(ERROR_COACH_NAME));

    companion object {
        fun makeError(error: ErrorType) {
            throw IllegalArgumentException(error.message)
        }
    }
}