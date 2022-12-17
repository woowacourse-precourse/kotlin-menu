package menu.view

import menu.constants.*
import menu.domain.Coach

class OutputView {

    fun printErrorMessage(message: String) {
        println(message)
    }

    fun printStartMent() {
        println(START_MENT)
        println()
    }

    fun printInputCoachNamesMent() {
        println(INPUT_COACH_NAMES_MENT)
    }

    fun printInputCantEatMenuMent(name: String) {
        println(INPUT_CANT_EAT_MENU_MENT.format(name))
    }

    fun printResult(categories: List<Int>, coaches: List<Coach>) {
        val categoryNames = listOf("일식", "한식", "중식", "아시안", "양식")
        println(RESULT_MENT)
        println(RESULT_HEADER)
        println(
            RESULT_CATEGORY.format(
                categoryNames[categories[0]],
                categoryNames[categories[1]],
                categoryNames[categories[2]],
                categoryNames[categories[3]],
                categoryNames[categories[4]]
            )
        )
        coaches.forEach {
            val menus = it.getRecommendedMenus()
            println(RESULT_COACH_MENU.format(it.name,menus[0], menus[1], menus[2], menus[3], menus[4]))
        }
        println(RESULT_SUCCESS_MENT)
    }
}