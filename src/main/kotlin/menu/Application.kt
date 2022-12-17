package menu

import menu.domain.validator.InputValidator
import menu.view.InputView
import menu.view.OutputView

private val inputView = InputView(InputValidator())
private val outputView = OutputView()

fun main() {
    progressStart()
    val coachNames = progressCoachNameStage()
}

private fun progressStart() {
    outputView.printStartPhrase()
    println()
}

private fun progressCoachNameStage(): List<String> {
    outputView.printRequestCoachNamesPhrase()
    val coachNames = inputView.readCoachNames()
    println()
    return coachNames
}

private fun progressGetBanMenu() {
}
