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

    private fun throwError(error: Error) {
        throw IllegalArgumentException(error.message)
    }
}