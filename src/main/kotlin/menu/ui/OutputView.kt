package menu.ui

import menu.data.ERROR_HEADER
import menu.data.PROGRAM_START

class OutputView {
    fun printInitNotice(){
        println(PROGRAM_START)
    }

    fun printErrorMessage(errorContent: String) {
        println(ERROR_HEADER + errorContent)
    }

}