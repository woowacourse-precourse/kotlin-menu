package menu.view

import menu.constants.String.Companion.STRING_DAY
import menu.constants.String.Companion.STRING_DIVIDER
import menu.constants.String.Companion.STRING_END_SYMBOL
import menu.constants.String.Companion.STRING_INPUT_COACH_NAME
import menu.constants.String.Companion.STRING_INPUT_FOOD_BAN
import menu.constants.String.Companion.STRING_PRINT_RESULT
import menu.constants.String.Companion.STRING_PRINT_RESULT_DONE
import menu.constants.String.Companion.STRING_PRINT_START
import menu.constants.String.Companion.STRING_START_SYMBOL
import menu.model.Recommender

class OutputView {
    fun printStart() {
        println(STRING_PRINT_START)
    }

    fun printInputCoachName() {
        println(STRING_INPUT_COACH_NAME)
    }

    fun printInputFoodBan(coach: String) {
        println("$coach" + STRING_INPUT_FOOD_BAN)
    }

    fun printResult(recommender: Recommender, result: MutableList<List<String>>) {
        println(STRING_PRINT_RESULT)
        println(STRING_DAY)
        printCategory(recommender)
        printMenu(recommender, result)
        println()
        println(STRING_PRINT_RESULT_DONE)
    }

    private fun printCategory(recommender: Recommender) {
        var resultString = "[ 카테고리 | "
        for (index in 0 until 5) {
            resultString += recommender.getEatingCategory(index) + addDivider(index, 5)
        }
        resultString += STRING_END_SYMBOL
        println(resultString)
    }

    private fun printMenu(recommender: Recommender, result: MutableList<List<String>>) {
        for (index in result[0].indices) {
            var startString = STRING_START_SYMBOL
            startString += recommender.getCoach(index) + STRING_DIVIDER
            var resultString = addMenuString(startString, index, result)
            resultString += STRING_END_SYMBOL
            println(resultString)
        }
    }

    private fun addMenuString(startString: String, index: Int, result: MutableList<List<String>>): String {
        var resultString = startString
        for (day in result.indices) {
            resultString += result[day][index] + addDivider(day, result.size)
        }
        return resultString
    }

    private fun addDivider(day: Int, size: Int): String {
        if (day < size - 1) {
            return STRING_DIVIDER
        }
        return ""
    }

    fun printException(message: String) {
        println(message)
    }
}