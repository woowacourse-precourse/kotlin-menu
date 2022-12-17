package menu.view

import camp.nextstep.edu.missionutils.Randoms
import menu.model.Menu
import menu.resource.*

class OutputView {

    fun printStartRecommend() {
        println(MENU_START)
    }

    fun printRequestName() {
        println(INPUT_COACH)
    }

    fun printRequestFood(name: String) {
        println(INPUT_FOOD.format(name))
    }
    fun printResult() {
        println(RECOMMEND_RESULT)
        println()

    }
    fun printCategories(categories: List<String>) {
        println(categories.joinToString(SEPARATOR, START_BRACKET, END_BRACKET))
    }

    fun printMenu(menu: List<Menu>) {

    }



    fun printEnd() {
        print(RECOMMEND_END)
    }
}