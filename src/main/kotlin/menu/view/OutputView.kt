package menu.view

import menu.model.Category
import menu.model.Coach
import menu.model.Days
import menu.util.Constants

class OutputView {

    fun printStartMessage() {
        println(Constants.START_GAME_MESSAGE)
    }

    fun printInputCoachesNameMessage() {
        println(Constants.INPUT_COACHES_NAME_MESSAGE)
    }

    fun printError(e : IllegalArgumentException) {
        println(e.message)
    }

    fun printInputFoodsNameMessage(input : String) {
        println(Constants.INPUT_HATE_FOOD_MESSAGE.format(input))
    }

    fun printResultMessage() {
        println(Constants.RESULT_MESSAGE)
    }

    fun printResult(categories : List<Category>, coaches : List<Coach>) {
        printDayResult()
        printCategoryResult(categories)
        coaches.forEach { printMenuResult(it.getName(), it.getMenu()) }
    }

    fun printDayResult() {
        println(Constants.MENU_RESULT_MESSAGE.format(Constants.DAY_MESSAGE, Days.getDays().joinToString(Constants.SEPERATE_CHAR)))
    }

    fun printCategoryResult(categories: List<Category>) {
        println(Constants.MENU_RESULT_MESSAGE.format(Constants.CATEGORY_MESSAGE, categories.joinToString(Constants.SEPERATE_CHAR)))
    }

    fun printMenuResult(name: String, menu : List<String>) {
        println(Constants.MENU_RESULT_MESSAGE.format(name, menu.joinToString(Constants.SEPERATE_CHAR)))
    }

    fun printJump() {
        println()
    }

    fun printEndMessage() {
        println(Constants.FINISH_MESSAGE)
    }

}