package menu.controller

import camp.nextstep.edu.missionutils.Randoms
import menu.Food
import menu.INSERT_NAME
import menu.START_MESSAGE
import menu.view.InputView
import menu.view.OutputView

class MenuController {

    fun start() {
        val names = startMenuRecommend()
        val cannotEatFood = askCannotEatFood(names)
        val determinedCategory = CategoryController().randomCategory()
        val result = mutableListOf<List<String>>()
        for (category in determinedCategory)
            result.add(determineWholeMenu(category, cannotEatFood, result))

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

    private fun determineWholeMenu(
        determinedCategory: Food,
        cannotEatFood: List<List<String>>,
        determinedMenu: MutableList<List<String>>
    ): MutableList<String> {
        val result = mutableListOf<String>()
        for (cantEat in cannotEatFood) {
            result.add(retryForRightMenu(determinedCategory.menu, determinedMenu, cantEat))
        }
        return result
    }

    private fun retryForRightMenu(
        menus: List<String>,
        determinedMenu: MutableList<List<String>>, cantEat: List<String>
    ): String {
        while (true) {
            var check = true
            val menu = Randoms.shuffle(menus)[0]
            if (checkDuplicateMenu(determinedMenu, menu) || checkCantEatFood(menu, cantEat))
                check = false
            if (check)
                return menu
        }
    }

    private fun checkDuplicateMenu(determinedMenu: MutableList<List<String>>, menu: String): Boolean {
        for (result in determinedMenu)
            if (result.contains(menu))
                return true
        return false
    }

    private fun checkCantEatFood(menu: String, cantEat: List<String>): Boolean {
        if (cantEat.contains(menu))
            return true
        return false
    }
}