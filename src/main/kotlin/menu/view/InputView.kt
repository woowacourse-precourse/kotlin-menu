package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.ENTER_AGAIN
import menu.Validator
import java.lang.IllegalArgumentException

class InputView {
    fun readNames(): List<String> {
        while (true) {
            val input = Console.readLine()
            val names = input.split(",")
            if (catchException { Validator().validateCoachName(names) })
                return names
        }
    }

    private fun catchException(validate: () -> Unit): Boolean {
        try {
            validate()
            return true
        } catch (e: IllegalArgumentException) {
            OutputView().printMessage(ENTER_AGAIN)
        }
        return false
    }
}