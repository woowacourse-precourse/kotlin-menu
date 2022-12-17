package menu

import camp.nextstep.edu.missionutils.Randoms
import menu.common.*
import menu.model.Category
import menu.model.Coach
import menu.model.DayOfWeek
import menu.model.Menu
import menu.view.InputView
import menu.view.OutputView

fun main() {
    OutputView.printMessage(WELCOME_MESSAGE)
    val coaches = askCoaches()

    val cantEatMenu = setCantEatMenu(coaches)



    OutputView.printMessage("\n" + RECOMMENDED_COMPLETE_MESSAGE)
}

private fun setCategoryByDayOfWeek(): Map<DayOfWeek, Category> {
    val foodTable = mutableMapOf<DayOfWeek, Category>()

    DayOfWeek.values().forEach { day ->
        var category: Category
        do {
            val categoryNumber = Randoms.pickNumberInRange(1, 5)
            category = Category.values().first { it.number == categoryNumber }
        } while (foodTable.values.count { it == category } >= 2)

        foodTable[day] = category
    }

    return foodTable
}

private fun askCoaches(): List<Coach> {
    OutputView.printMessage("\n" + COACHES_INPUT_MESSAGE)
    return InputView.readCoaches().map { Coach(it) }
}

private fun setCantEatMenu(coaches: List<Coach>): Map<String, List<String>> {
    val cantEatMenu = mutableMapOf<String, List<String>>()

    coaches.forEach { coach ->
        OutputView.printMessage("\n" + CANT_EAT_MENU_INPUT_MESSAGE.format(coach))
        val menus = InputView.readMenus().map { Menu(it) }
        coach.setCantEatMenus(menus)
    }

    return cantEatMenu
}