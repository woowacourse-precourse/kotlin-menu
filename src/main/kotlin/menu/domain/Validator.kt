package menu.domain

import menu.resource.*

class Validator {
    fun checkValidateCoach(coach: List<String>) {
        for (data in coach) println(data)
        require(coach.size == coach.distinct().size && coach.size >= MIN_RANGE_COACH_NUMBER && coach.size <= MAX_RANGE_COACH_NUMBER) { ERROR_INPUT_COACH }
        coach.forEach {
            name -> require(name.length in MIN_RANGE_COACH_NAME_LENGTH..MAX_RANGE_COACH_NAME_LENGTH) { ERROR_INPUT_COACH }
        }
    }

    fun checkValidateFood(food: List<String>) {
        require(food.size == food.distinct().size && food.size >= MIN_RANGE_FOOD_NUMBER && food.size <= MAX_RANGE_FOOD_NUMBER)

        food.forEach {
            it -> require(FOOD_ALL.contains(it) || it.length == MIN_RANGE_FOOD_NUMBER) { ERROR_INPUT_FOOD}
        }
    }
}