package menu

import camp.nextstep.edu.missionutils.Randoms
import menu.common.*
import menu.model.Category
import menu.model.DayOfWeek
import menu.view.InputView
import menu.view.OutputView

fun main() {
    val foodTable = setCategoryByDayOfWeek()

    OutputView.printMessage(WELCOME_MESSAGE)
    val coaches = askCoaches()

    val cantEatMenu = setCantEatMenu(coaches)
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

private fun askCoaches(): List<String> {
    OutputView.printMessage(COACHES_INPUT_MESSAGE)
    return InputView.readCoaches()
}

private fun setCantEatMenu(coaches: List<String>): Map<String, List<String>> {
    val cantEatMenu = mutableMapOf<String, List<String>>()

    coaches.forEach { coach ->
        OutputView.printMessage(CANT_EAT_MENU_INPUT_MESSAGE.format(coach))
        val menus = InputView.readMenus()
        cantEatMenu[coach] = menus
    }

    return cantEatMenu
}