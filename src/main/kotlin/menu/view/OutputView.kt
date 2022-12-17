package menu.view

import menu.PrintMessage.INPUT_COACH_NAME_MESSAGE
import menu.PrintMessage.START_MESSAGE

class OutputView {
    fun printStartMessage() {
        println(START_MESSAGE)
    }

    fun printInputCoachNameMessage() {
        println(INPUT_COACH_NAME_MESSAGE)
    }
}