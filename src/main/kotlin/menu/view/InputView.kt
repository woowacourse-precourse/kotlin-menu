package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.values.GameMessage

class InputView (private val outputView:OutputView){
    private val validator = InputValidator()
    fun readCoach(): List<String> {
        outputView.printMessage(GameMessage.REQUEST_COACH_NAME)
        val input = Console.readLine()
        validator.validateCoach(input)
        return input.split(',')
    }

    fun readHateMenu(name:String):List<String>{
        outputView.printMessage(GameMessage.REQUEST_HATE_MENU.format(name))
        val input = Console.readLine()
        validator.validateHateMenu(input)
        return input.split(',')
    }
}