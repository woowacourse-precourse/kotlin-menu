package menu.view

import menu.constants.MenuPhrases.CONCLUSION_PHRASE
import menu.constants.MenuPhrases.END_PHRASE
import menu.constants.MenuPhrases.REQUEST_COACH_BAN_MENUS_PHRASE
import menu.constants.MenuPhrases.REQUEST_COACH_NAMES_PHRASE
import menu.constants.MenuPhrases.START_PHRASE
import menu.constants.MenuPhrases.WEEK_OF_THE_DAY_PHRASE

class OutputView {

    fun printStartPhrase() {
        println(START_PHRASE)
    }

    fun printRequestCoachNamesPhrase() {
        println(REQUEST_COACH_NAMES_PHRASE)
    }

    fun printRequestCoachBanMenusPhrase() {
        println(REQUEST_COACH_BAN_MENUS_PHRASE)
    }

    fun printConclusionPhrase() {
        println(CONCLUSION_PHRASE)
    }

    fun printWeekOfTheDayPhrase() {
        println(WEEK_OF_THE_DAY_PHRASE)
    }

    fun printEndPhrase() {
        println(END_PHRASE)
    }
}
