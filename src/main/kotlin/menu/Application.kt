package menu

import menu.common.*
import menu.model.Coach
import menu.model.Menu
import menu.view.InputView
import menu.view.OutputView

fun main() {
    OutputView.printMessage(WELCOME_MESSAGE)
    val coaches = askCoaches()

    setCantEatMenu(coaches)

    MenuRecommender.recommendMenus(coaches)

    OutputView.printRecommendedMenuTable(coaches)
    OutputView.printMessage("\n" + RECOMMENDED_COMPLETE_MESSAGE)
}

private fun askCoaches(): List<Coach> {
    OutputView.printMessage("\n" + COACHES_INPUT_MESSAGE)
    return InputView.readCoaches().map { Coach(it) }
}

private fun setCantEatMenu(coaches: List<Coach>) =
    coaches.forEach { coach ->
        OutputView.printMessage("\n" + CANT_EAT_MENU_INPUT_MESSAGE.format(coach.name()))
        val menus = InputView.readMenus().map { Menu(it) }
        coach.setCantEatMenus(menus)
    }