package menu

import menu.controller.Controller
import menu.view.InputValidator
import menu.view.InputView
import menu.view.OutputView

fun main() {
    val controller = Controller(outputView = OutputView(), inputView = InputView(InputValidator()))

    controller.start()
    controller.inputNames()
    controller.inputInedibleMenus()
    controller.suggestMenus()
}
