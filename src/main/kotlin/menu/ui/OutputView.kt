package menu.ui

import menu.data.ENTER_COACH_NAME
import menu.data.ENTER_NO_EATING
import menu.data.ERROR_HEADER
import menu.data.PROGRAM_START

class OutputView {
    fun printInitNotice(){
        println(PROGRAM_START)
    }

    fun printNoticeEnterName(){
        println(ENTER_COACH_NAME)
    }

    fun printNoticeNoEating(coachName: String) {
        println("$coachName$ENTER_NO_EATING")
    }

    fun printErrorMessage(errorContent: String) {
        println(ERROR_HEADER + errorContent)
    }

}