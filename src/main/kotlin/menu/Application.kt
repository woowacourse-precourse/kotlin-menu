package menu

import menu.controller.CategoryController
import menu.controller.MenuController
import menu.view.InputView
import menu.view.OutputView

fun main() {
    val names = startMenuRecommend()
    val cannotEatFood = askCannotEatFood(names)
    val determinedCategory = CategoryController().randomCategory()
    val result = mutableListOf<List<String>>()
    for (category in determinedCategory)
        result.add(MenuController().determineWholeMenu(category, cannotEatFood, result))

    OutputView().printResult(names, determinedCategory, result)
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
