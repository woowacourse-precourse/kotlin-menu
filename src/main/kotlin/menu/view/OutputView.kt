package menu.view

import menu.common.RECOMMENDED_MENU_RESULT_HEADER
import menu.model.Category
import menu.model.Coach
import menu.model.DayOfWeek

object OutputView {

    fun printMessage(message: String) = println(message)

    fun printRecommendedMenuTable(coaches: List<Coach>) {
        println("\n" + RECOMMENDED_MENU_RESULT_HEADER)
        println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]")
        println(createCategoryLine(coaches.first().recommendedCategories()))
        coaches.forEach { coach -> println(createMenuLineOfCoach(coach)) }
    }

    private fun createCategoryLine(categories: List<Category>): String =
        "[ 카테고리 | " + categories.joinToString(" | ") { it.categoryName } + " ]"

    private fun createMenuLineOfCoach(coach: Coach): String {
        val recommendedMenus = DayOfWeek.values().map { coach.getRecommendedMenu(it) }

        return  "[ " + coach.name() + " | " + recommendedMenus.joinToString(" | ") { it.name } + " ]"
    }
}