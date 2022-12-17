package menu

class InputValidation {

    fun checkNumberOfCoach(input: String):List<String>{
        val coaches = input.split(",")
        if(coaches.size < MIN_COACH_NUMBER || coaches.size> MAX_COACH_NUMBER ) throw IllegalArgumentException(
            COACH_NUMBER_ERROR_MESSAGE)
        return coaches
    }

    fun checkCoachNameLength(coaches:List<String>){
        if(!coaches.all{name->
                name.length in MIN_COACH_NAME_LENGTH..MAX_COACH_NAME_LENGTH
        }) throw IllegalArgumentException(COACH_NAME_LENGTH_ERROR_MESSAGE)
    }

    fun checkNumberOfImpossibleFood(input: String):List<String>{
        val foods = input.split(",")
        if(foods.size> MAX_IMPOSSIBLE_FOOD_NUMBER ) throw IllegalArgumentException(MENU_NUMBER_ERROR_MESSAGE)
        return foods
    }

    fun checkInvalidImpossibleFood(foods: List<String>){
        val util = Util()
        val allFood= util.getAllFood()
        foods.forEach {food->
            if (!allFood.contains(food)) throw IllegalArgumentException(MENU_INVALID_ERROR_MESSAGE)
        }
    }

    companion object{
        const val MAX_COACH_NUMBER = 5
        const val MIN_COACH_NUMBER = 2
        const val MIN_COACH_NAME_LENGTH = 2
        const val MAX_COACH_NAME_LENGTH = 4
        const val MAX_IMPOSSIBLE_FOOD_NUMBER = 2
        const val PREFIX = "[ERROR]"
        const val COACH_NUMBER_ERROR_MESSAGE = PREFIX+" 코치는 2명이상, 5명 이하여야 합니다."
        const val COACH_NAME_LENGTH_ERROR_MESSAGE = PREFIX+"코치의 이름은 2글자 이상, 4글자이하여야 합니다."
        const val MENU_NUMBER_ERROR_MESSAGE = PREFIX+"못먹는 음식의 개수는 최대 2개 입니다."
        const val MENU_INVALID_ERROR_MESSAGE = PREFIX+"음식이 메뉴의 포함되어 있지 않습니다."
    }
}