package menu

import menu.common.*
import menu.view.InputView
import menu.view.OutputView

fun main() {
    OutputView.printMessage(WELCOME_MESSAGE)
    val coaches = askCoaches()
}

fun askCoaches(): List<String> {
    OutputView.printMessage(COACHES_INPUT_MESSAGE)
    return InputView.readCoaches()
}
