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

    fun printResult(categories: List<String>) {
        println(RECOMMEND_RESULT)
        println(RECOMMEND_PART)
        println(categories.joinToString(SEPARATOR, START_BRACKET, END_BRACKET))
    }

    fun printMenu(menu: List<Menu>) {
        menu.forEach { it ->
            println(it.getMenu().joinToString(SEPARATOR, START_BRACKET, END_BRACKET))
        }
        print(RECOMMEND_END)
    }
}