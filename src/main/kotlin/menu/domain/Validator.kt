package menu.domain

import menu.resource.*

class Validator {
    fun checkValidateCoach(coach: List<String>) {
        require(coach.size == coach.distinct().size && coach.size >= MIN_RANGE_COACH_NUMBER && coach.size <= MAX_RANGE_COACH_NUMBER) { ERROR_INPUT_COACH }
        coach.forEach {
            name -> require(name.length in MIN_RANGE_COACH_NAME_LENGTH..MAX_RANGE_COACH_NAME_LENGTH) { ERROR_INPUT_COACH }
        }
    }

    fun checkValidateFood(food: List<String>) {
    }
}