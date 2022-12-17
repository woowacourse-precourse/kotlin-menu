package menu.domain

import menu.utils.*

class CoachName(private val value: String) {
    init {
        require(isNotBlank()) { ERROR.format(ERROR_NAME_BLANK) }
        require(isNameRange()) { ERROR.format(ERROR_NAME_LENGTH) }
    }

    private fun isNotBlank(): Boolean =
        value.isNotBlank()

    private fun isNameRange(): Boolean =
        value.length >= MIN_NAME_LENGTH && value.length <= MAX_NAME_LENGTH
}