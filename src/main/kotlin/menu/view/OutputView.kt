package menu.view

import menu.constants.INPUT_CANT_EAT_MENU_MENT
import menu.constants.INPUT_COACH_NAMES_MENT
import menu.constants.START_MENT

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

    fun printInputCantEatMenuMent(name:String) {
        println(INPUT_CANT_EAT_MENU_MENT.format(name))
    }
}