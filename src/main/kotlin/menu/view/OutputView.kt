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
        for(coach in names.indices)
            printCoachMenu(names[coach],result[coach])
        println()
        print(END)
    }

    private fun printDay() {
        val days = listOf("월요일","화요일","수요일","목요일","금요일")
        print("${PRINT_RESULT_START}구분")
        for (day in days)
            print(PRINT_RESULT_MID+day)
        println(PRINT_RESULT_END)
    }

    private fun printCategory(categories: List<Food>) {
        print("${PRINT_RESULT_START}카테고리")
        for (category in categories)
            print(PRINT_RESULT_MID+category.name)
        println(PRINT_RESULT_END)
    }

    private fun printCoachMenu(name: String, menu: List<String>) {
        print(PRINT_RESULT_START+name)
        for (food in menu)
            print(PRINT_RESULT_MID+food)
        println(PRINT_RESULT_END)
    }
}