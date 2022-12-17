package menu

import menu.domain.validator.InputValidator
import menu.view.InputView
import menu.view.OutputView

private val inputView = InputView(InputValidator())
private val outputView = OutputView()
fun main() {
    progressStart()
}

private fun progressStart() {
    outputView.printStartPhrase()
    println()
}
