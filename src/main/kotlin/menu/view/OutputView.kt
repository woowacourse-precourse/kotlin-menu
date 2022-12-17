package menu.view

import menu.domain.Coach
import menu.utils.Constant.CATEGORY
import menu.utils.Constant.CLOSE_BRACKET
import menu.utils.Constant.DIVISION
import menu.utils.Constant.FRIDAY
import menu.utils.Constant.MONDAY
import menu.utils.Constant.OPEN_BRACKET
import menu.utils.Constant.SEPARATOR
import menu.utils.Constant.THURSDAY
import menu.utils.Constant.TUESDAY
import menu.utils.Constant.WEDNESDAY
import menu.utils.InfoMessage.INPUT_COACH_NAME_MESSAGE
import menu.utils.InfoMessage.INPUT_HATE_MENUS_MESSAGE
import menu.utils.InfoMessage.RECOMMEND_MENU_END_MESSAGE
import menu.utils.InfoMessage.RECOMMEND_MENU_RESULT_MESSAGE
import menu.utils.InfoMessage.START_MESSAGE

class OutputView {
    fun printStartMessage() {
        println("$START_MESSAGE\n")
    }

    fun printInputCoachNameMessage() {
        println(INPUT_COACH_NAME_MESSAGE)
    }

    fun printInputCoachHateMenusMessage(coachName: String) {
        println("\n$coachName$INPUT_HATE_MENUS_MESSAGE")
    }

    fun printRecommendMenuResult(coaches: List<Coach>, categories: List<String>) {
        printRecommendMenuResultMessage()
        printDayOfWeek()
        printCategory(categories)
        coaches.forEach { coach -> printCoachesMenus(coach.getCoachName(), coach.getMenus()) }
        printRecommendMenuEndMessage()
    }

    private fun printRecommendMenuResultMessage() {
        println("\n$RECOMMEND_MENU_RESULT_MESSAGE")
    }

    private fun printCoachesMenus(coachName: String, menus: List<String>) {
        print("$OPEN_BRACKET $coachName ")
        printItems(menus)
    }

    private fun printCategory(categories: List<String>) {
        print("$OPEN_BRACKET $CATEGORY ")
        printItems(categories)
    }

    private fun printDayOfWeek() {
        val days = listOf(MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY)
        print("$OPEN_BRACKET $DIVISION ")
        printItems(days)
    }

    private fun printItems(items: List<String>) {
        items.forEach { item -> print("$SEPARATOR $item ") }
        println(CLOSE_BRACKET)
    }

    private fun printRecommendMenuEndMessage() {
        println("\n$RECOMMEND_MENU_END_MESSAGE")
    }
}