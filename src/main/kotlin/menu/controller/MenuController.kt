package menu.controller

import menu.INSERT_NAME
import menu.START_MESSAGE
import menu.view.InputView
import menu.view.OutputView

class MenuController {
    fun start() {
        val names = startMenuRecommend()
        val cannotEatFood = askCannotEatFood(names)

    }

    private fun startMenuRecommend(): List<String> {
        OutputView().printMessage(START_MESSAGE)
        OutputView().printMessage(INSERT_NAME)
        return InputView().readNames()
    }

    private fun askCannotEatFood(names: List<String>): MutableList<List<String>> {
        val cannotEatFood = mutableListOf<List<String>>()
        for (name in names) {
            OutputView().printCanNotEat(name)
            cannotEatFood.add(InputView().readCannotEat())
        }
        return cannotEatFood
    }
}