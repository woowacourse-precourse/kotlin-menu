package menu.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    private val validator = InputValidator()
    fun readCoach(): List<String> {
        val input = Console.readLine()
        validator.validateCoach(input)
        return input.split(',')
    }

    fun readHateMenu():List<String>{
       val input = Console.readLine()
        validator.validateHateMenu(input)
        return input.split(',')
    }
}