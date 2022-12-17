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

        for (cantEat in cannotEatFood)
            result.add(determineMenu(determinedCategory,cantEat))
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


    private fun determineMenu(determinedCategory: List<Food>, cantEat: List<String>): List<String> {
        val determinedMenu = mutableListOf<String>()
        var category = 0
        while (determinedMenu.size < 5) {
            val menus = determinedCategory[category].menu
            val menu: String = Randoms.shuffle(menus)[0]
            if(checkDuplicateMenu(determinedMenu, menu) || checkCantEatFood(menu, cantEat))
                continue
            determinedMenu.add(menu)
            category++
        }
        return determinedMenu
    }

    private fun checkDuplicateMenu(determinedMenu: MutableList<String>, menu: String): Boolean {
        if (determinedMenu.contains(menu))
            return true
        return false
    }

    private fun checkCantEatFood(menu: String, cantEat: List<String>): Boolean {
        if (cantEat.contains(menu))
            return true
        return false
    }
}