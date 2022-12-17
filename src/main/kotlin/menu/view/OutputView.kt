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
        println()
        println(INPUT_CANT_EAT_MENU_MENT.format(name))
    }

    fun printResult(categories: List<String>, coaches: List<Coach>) {
        println()
        println(RESULT_MENT)
        println(RESULT_HEADER)
        println(
            RESULT_CATEGORY.format(categories[0], categories[1], categories[2], categories[3], categories[4])
        )
        printCoachMenuResult(coaches)
        println()
        println(RESULT_SUCCESS_MENT)
    }

    private fun printCoachMenuResult(coaches: List<Coach>) {
        coaches.forEach {
            val menus = it.getRecommendedMenus()
            println(RESULT_COACH_MENU.format(it.name, menus[0], menus[1], menus[2], menus[3], menus[4]))
        }
    }
}