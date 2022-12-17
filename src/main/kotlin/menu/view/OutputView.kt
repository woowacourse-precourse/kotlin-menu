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

    fun printResult(names: List<String>, determinedCategory: List<Food>, result: List<List<String>>) {
        println(PRINT_RESULT)
        printDay()
        printCategory(determinedCategory)
        printCoachMenu(names, result)
        println()
        print(END)
    }

    private fun printDay() {
        val days = listOf("월요일", "화요일", "수요일", "목요일", "금요일")
        print("${PRINT_RESULT_START}구분")
        for (day in days)
            print(PRINT_RESULT_MID + day)
        println(PRINT_RESULT_END)
    }

    private fun printCategory(categories: List<Food>) {
        print("${PRINT_RESULT_START}카테고리")
        for (category in categories)
            print(PRINT_RESULT_MID + category.name)
        println(PRINT_RESULT_END)
    }

    private fun printCoachMenu(names: List<String>, result: List<List<String>>) {
        for (coach in names.indices) {
            print(PRINT_RESULT_START + names[coach])
            for (day in 0 until 5) {
                print(PRINT_RESULT_MID + result[day][coach])
            }
            println(PRINT_RESULT_END)
        }
    }
}