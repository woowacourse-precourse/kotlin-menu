package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.ENTER_AGAIN
import menu.Validator
import java.lang.IllegalArgumentException

class InputView {
    fun readNames(): List<String> {
        val input = Console.readLine()
        val names = input.split(",")
        return names
//        while (true) {
//            val command = Console.readLine()
//            if (catchException { Validator().validateRetryAndQuit(command) })
//                return command
//        }
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