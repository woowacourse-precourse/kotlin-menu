package menu

import menu.controller.ServiceController
import menu.domain.Generator
import menu.domain.Validator
import menu.view.InputView
import menu.view.OutputView

fun main() {
    val validator = Validator()
    val outputView = OutputView()
    val inputView = InputView(validator)
    val generator = Generator()
    val mainController = ServiceController(inputView, outputView, generator)

    mainController.run()
}
