package menu

import menu.domain.validator.InputValidator
import menu.view.InputView
import menu.view.OutputView

private val inputView = InputView(InputValidator())
private val outputView = OutputView()

fun main() {
    progressStart()
    val coachNames = progressCoachNameStage()
    val coachWithMenuBans = progressGetBanMenu(coachNames)
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

private fun progressGetBanMenu(coachNames: List<String>): List<List<String>> {
    val coachWithMenuBans = mutableListOf<List<String>>()
    for (coachName in coachNames) {
        outputView.printRequestCoachBanMenusPhrase(coachName)
        coachWithMenuBans.add(inputView.readCoachWithMenuBan(coachName))
        println()
    }
    return coachWithMenuBans
}
