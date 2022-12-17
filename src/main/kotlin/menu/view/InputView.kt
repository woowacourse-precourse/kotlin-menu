package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.exception.Validator

class InputView {
    private val validator = Validator()
    fun readCoachNames(): List<String> {
        val input = Console.readLine()
        return validator.checkCoachNames(input)
    }
}