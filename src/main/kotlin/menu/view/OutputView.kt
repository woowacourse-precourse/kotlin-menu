package menu.view

import menu.common.RECOMMENDED_MENU_RESULT_HEADER
import menu.model.Category
import menu.model.DayOfWeek

object OutputView {

    fun printMessage(message: String) = println(message)
    fun printRecommendedMenuTable(
        foodTable: Map<DayOfWeek, Category>,
        recommendedMenuTable: Map<String, Map<DayOfWeek, String>>
    ) {
        println("\n" + RECOMMENDED_MENU_RESULT_HEADER)
        println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]")
        println(createCategoryLine(foodTable))
        recommendedMenuTable.keys.forEach { coach -> println(createMenuLineOfCoach(coach, recommendedMenuTable[coach]!!)) }
    }

    private fun createCategoryLine(foodTable: Map<DayOfWeek, Category>): String {
        val days = foodTable.keys.sortedBy { day -> day.ordinal }

        return "[ 카테고리 | " + days.joinToString(" | ") { foodTable[it]!!.categoryName } + " ]"
    }

    private fun createMenuLineOfCoach(coach: String, recommendedMenus: Map<DayOfWeek, String>): String {
        val menus = recommendedMenus.entries.sortedBy { it.key.ordinal }.map { it.value }

        return "[ " + coach + " | " + menus.joinToString(" | ") + " ]"
    }
}