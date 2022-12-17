package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.util.InputValidator

class InputView(
    private val inputValidator: InputValidator = InputValidator()
) {

    private fun input(): String = Console.readLine()
}