package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.values.MenuMessage

class InputView(private val outputView: OutputView) {
    private val validator = InputValidator()
    fun readCoach(): List<String> {
        outputView.printMessage(MenuMessage.REQUEST_COACH_NAME)
        val input = Console.readLine()
        validator.validateCoach(input)
        outputView.printMessage(MenuMessage.ENTER)
        return input.split(',')
    }

    fun readHateMenu(name: String): List<String> {
        outputView.printMessage(MenuMessage.REQUEST_HATE_MENU.format(name))
        val input = Console.readLine()
        validator.validateHateMenu(input)
        outputView.printMessage(MenuMessage.ENTER)
        return input.split(',')
    }
}