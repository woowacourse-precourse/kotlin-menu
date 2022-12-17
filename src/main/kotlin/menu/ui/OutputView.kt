package menu.ui

import menu.data.*

class OutputView {
    fun printInitNotice() {
        println(PROGRAM_START)
    }

    fun printNoticeEnterName() {
        println(ENTER_COACH_NAME)
    }

    fun printNoticeNoEating(coachName: String) {
        println("$coachName$ENTER_NO_EATING")
    }

    fun printNoticeResult() {
        println(RECOMMEND_MENU)
    }

    fun printFinishNotice(){
        println(PROGRAM_END)
    }
    fun printErrorMessage(errorContent: String) {
        println(ERROR_HEADER + errorContent)
    }

}