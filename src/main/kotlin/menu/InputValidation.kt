package menu

class InputValidation {

    fun checkNumberOfCoach(input: String){
        val coaches = input.split(",")
        if(coaches.size < MIN_COACH_NUMBER || coaches.size> MAX_COACH_NUMBER ) throw IllegalArgumentException()
    }

    fun checkCoachNameLength(coaches:List<String>){
        if(coaches.all{name->
            name.length < MIN_COACH_NAME_LENGTH || name.length > MAX_COACH_NAME_LENGTH
        }) throw IllegalArgumentException()
    }

    companion object{
        const val MAX_COACH_NUMBER = 5
        const val MIN_COACH_NUMBER = 2
        const val MIN_COACH_NAME_LENGTH = 2
        const val MAX_COACH_NAME_LENGTH = 4
    }
}