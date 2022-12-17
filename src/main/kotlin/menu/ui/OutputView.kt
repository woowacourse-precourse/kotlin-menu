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
        println("\n$coachName$ENTER_NO_EATING")
    }

    fun printNoticeResult() {
        println(RECOMMEND_MENU)
    }

    fun printFinishNotice() {
        println(PROGRAM_END)
    }

    fun printCategoryContainer(categoryContainer: MutableList<String>) {
        val categoryResult = mutableListOf("카테고리")
        categoryResult.addAll(categoryContainer)

        println(categoryResult.joinToString(prefix = LEFT, separator = BAR, postfix = RIGHT))
    }

    fun printFoodContainer(foodContainer: MutableList<String>, coachName: String) {
        val foodResult = mutableListOf(coachName)
        foodResult.addAll(foodContainer)

        println(foodResult.joinToString(prefix = LEFT, separator = BAR, postfix = RIGHT))
    }

    fun printErrorMessage(errorContent: String) {
        println(ERROR_HEADER + errorContent)
    }

}