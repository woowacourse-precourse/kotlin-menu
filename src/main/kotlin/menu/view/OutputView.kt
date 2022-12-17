package menu.view

import menu.model.Category
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

}