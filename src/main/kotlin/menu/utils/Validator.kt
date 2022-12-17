package menu.utils

import menu.utils.ErrorMessage.COACH_COUNT_ERROR_MESSAGE
import menu.utils.ErrorMessage.COACH_DUPLICATION_ERROR_MESSAGE
import menu.utils.ErrorMessage.COACH_NAME_LENGTH_ERROR_MESSAGE

object Validator {
    fun checkCoachesValid(input: String) {
        checkCoachesCount(input)
        checkCoachesDuplication(input)
    }

    private fun checkCoachesCount(input: String) {
        val size = input.split(',').size
        require(size in 2..5) { COACH_COUNT_ERROR_MESSAGE }
    }

    private fun checkCoachesDuplication(input: String) {
        val coaches = input.split(',')
        val distinctCoaches = coaches.distinct()
        require(coaches.size == distinctCoaches.size) { COACH_DUPLICATION_ERROR_MESSAGE }
    }

    fun checkCoachNameValid(input: String) {
        require(input.length in 2..4) { COACH_NAME_LENGTH_ERROR_MESSAGE }
    }
}