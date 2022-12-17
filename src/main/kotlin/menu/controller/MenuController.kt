package menu.controller

import menu.INSERT_NAME
import menu.START_MESSAGE
import menu.view.InputView
import menu.view.OutputView

class MenuController {
    fun start() {
        OutputView().printMessage(START_MESSAGE)
        OutputView().printMessage(INSERT_NAME)
        val names = InputView().readNames()
    }
}