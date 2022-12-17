package menu

import camp.nextstep.edu.missionutils.Console

class InputView {
    private val inputValidation = InputValidation()
    fun readCoaches():List<String>{
        return try {
            val input = Console.readLine()
            inputValidation.checkNumberOfCoach(input)
            val coaches = input.split(",")
            inputValidation.checkCoachNameLength(coaches)
            return coaches
        }catch (e:IllegalArgumentException){
            println(e.message)
            readCoaches()
        }
    }
}