package menu.view

import menu.*

class OutputView {
    fun printMessage(msg: String) {
        println(msg)
    }

    fun printCanNotEat(name: String) {
        println(name + INSERT_CANNOT_EAT)
    }

    fun printErrorMessage(msg: String) {
        println("[ERROR] $msg")
    }

    fun printResult() {
        println(PRINT_RESULT)
        printDay()

    }

    private fun printDay() {
        val days = listOf("월요일","화요일","수요일","목요일","금요일")
        print("${PRINT_RESULT_START}구분")
        for (day in days)
            print(PRINT_RESULT_MID+day)
        println(PRINT_RESULT_END)
    }
}