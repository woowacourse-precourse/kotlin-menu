package menu.domain

import menu.resource.ERROR_INPUT_COACH

class Validator {
    fun checkValidateCoach(coach: List<String>) {
        require(coach.size == coach.distinct().size && coach.size >= 2 && coach.size <= 5) { ERROR_INPUT_COACH }
        coach.forEach {
            name -> require(name.length in 2..4) { ERROR_INPUT_COACH }
        }
    }

    fun checkValidateFood(food: List<String>) {
    }
}