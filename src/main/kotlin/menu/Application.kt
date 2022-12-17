package menu

import menu.domain.CategoryPicker
import menu.domain.MenuPicker
import menu.domain.categorynumbergenerator.RandomCategoryNumberGenerator
import menu.domain.menugenerator.RandomMenuGenerator
import menu.domain.validator.InputValidator
import menu.view.InputView
import menu.view.OutputView

private val inputView = InputView(InputValidator())
private val outputView = OutputView()
private val categoryPicker = CategoryPicker(RandomCategoryNumberGenerator())
private val menuPicker = MenuPicker(RandomMenuGenerator())

fun main() {
    progressStart()
    val coachNames = progressCoachNameStage()
    val coachWithMenuBans = progressGetBanMenu(coachNames)
    val recommendResult = progressRecommend(coachWithMenuBans)
    progressConclusion()
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

private fun progressRecommend(coachWithMenuBans: List<List<String>>) {
    outputView.printConclusionPhrase()
    val categorys = categoryPicker.genrateCategorys()
    val recommendResult = mutableListOf<List<String>>()
    outputView.printWeekOfTheDayPhrase()
    println(categorys.map { it.korean }.joinToString(separator = " | ", prefix = "[ 카테고리 | ", postfix = " ]"))
    for (coachWithMenuBan in coachWithMenuBans) {
        print("[ ${coachWithMenuBan[0]} | ")
        println(menuPicker.generateMenus(coachWithMenuBan,categorys).joinToString(separator = " | ", postfix = " ]"))
    }
}

private fun progressConclusion() {
    println()
    outputView.printEndPhrase()
}
