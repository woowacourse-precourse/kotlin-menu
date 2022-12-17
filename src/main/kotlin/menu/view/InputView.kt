package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.exceptions.ValidateUserInput

object InputView {
    fun inputCoachNames() : String{
        val input = Console.readLine().trim()
        ValidateUserInput.validateInputDisallowBlank(input)
        return input
    }
}