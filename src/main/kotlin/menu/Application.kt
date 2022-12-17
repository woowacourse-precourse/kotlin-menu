package menu

import menu.domain.MenuController
import menu.domain.validator.InputValidator
import menu.view.InputView
import menu.view.OutputView

private val inputView = InputView(InputValidator())
private val outputView = OutputView()
private val menuController = MenuController()
fun main() {
    progressStart()
    progressCoachNameStage()
}

private fun progressStart() {
    outputView.printStartPhrase()
    println()
}

private fun progressCoachNameStage() {
    outputView.printRequestCoachNamesPhrase()
    menuController.updateCoachs(inputView.readCoachNames())
    println()
}
