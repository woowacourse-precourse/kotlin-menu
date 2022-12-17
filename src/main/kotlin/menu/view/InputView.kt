package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.domain.Validator

class InputView(
    private val validator: Validator,
    private val outputView: OutputView
) {

    fun read(): Int {
        outputView.printMessage("")
        val input = Console.readLine()

        validator.validate(input)

        return input.toInt()
    }

}