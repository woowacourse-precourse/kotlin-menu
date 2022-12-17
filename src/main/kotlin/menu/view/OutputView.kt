package menu.view

import menu.utils.InfoMessage.INPUT_COACH_NAME_MESSAGE
import menu.utils.InfoMessage.START_MESSAGE

class OutputView {
    fun printStartMessage() {
        println(START_MESSAGE)
    }

    fun printInputCoachNameMessage() {
        println(INPUT_COACH_NAME_MESSAGE)
    }
}