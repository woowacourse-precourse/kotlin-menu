package menu.view

import menu.utils.InfoMessage.INPUT_COACH_NAME_MESSAGE
import menu.utils.InfoMessage.INPUT_HATE_MENUS_MESSAGE
import menu.utils.InfoMessage.RECOMMEND_MENU_END_MESSAGE
import menu.utils.InfoMessage.RECOMMEND_MENU_RESULT_MESSAGE
import menu.utils.InfoMessage.START_MESSAGE

class OutputView {
    fun printStartMessage() {
        println(START_MESSAGE)
    }

    fun printInputCoachNameMessage() {
        println(INPUT_COACH_NAME_MESSAGE)
    }

    fun printInputCoachHateMenusMessage(coachName: String) {
        println("$coachName$INPUT_HATE_MENUS_MESSAGE")
    }

    fun printRecommendMenuResultMessage() {
        println(RECOMMEND_MENU_RESULT_MESSAGE)
    }

    fun printRecommendMenuEndMessage() {
        println(RECOMMEND_MENU_END_MESSAGE)
    }
}