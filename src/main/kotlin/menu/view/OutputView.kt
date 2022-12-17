package menu.view

import menu.resource.*

class OutputView {

    fun printStartRecommend(){
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
    }

    fun printEnd() {
        print(RECOMMEND_END)
    }
}