package menu

class InputValidation {

    fun checkNumberOfCoach(input: String):List<String>{
        val coaches = input.split(",")
        if(coaches.size < MIN_COACH_NUMBER || coaches.size> MAX_COACH_NUMBER ) throw IllegalArgumentException()
        return coaches
    }

    fun checkCoachNameLength(coaches:List<String>){
        if(coaches.all{name->
            name.length < MIN_COACH_NAME_LENGTH || name.length > MAX_COACH_NAME_LENGTH
        }) throw IllegalArgumentException()
    }

    fun checkNumberOfImpossibleFood(input: String):List<String>{
        val foods = input.split(",")
        if(foods.size> MAX_IMPOSSIBLE_FOOD_NUMBER ) throw IllegalArgumentException()
        return foods
    }

    fun checkInvalidImpossibleFood(foods: List<String>,menu:List<String>){
        foods.forEach {food->
            if (!menu.contains(food)) throw IllegalArgumentException()
        }
    }

    companion object{
        const val MAX_COACH_NUMBER = 5
        const val MIN_COACH_NUMBER = 2
        const val MIN_COACH_NAME_LENGTH = 2
        const val MAX_COACH_NAME_LENGTH = 4
        const val MAX_IMPOSSIBLE_FOOD_NUMBER = 2
    }
}