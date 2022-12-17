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
        val determinedCategory = randomCategory()
        val result = mutableListOf<List<String>>()

        for (cantEat in cannotEatFood)
            result.add(determineMenu(determinedCategory,cantEat))

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

    fun randomCategory(): List<String> {
        val determinedCategory = mutableListOf<String>()
        val categories = listOf("일식", "한식", "중식", "아시안", "양식")
        while (determinedCategory.size < 5) {
            val category: String = categories[Randoms.pickNumberInRange(0, 4)]
            if (isContainedOver2(determinedCategory, category))
                continue
            determinedCategory.add(category)
        }
        return determinedCategory
    }

    private fun isContainedOver2(determinedCategory: MutableList<String>, category: String): Boolean {
        var count = 0
        for (determinedOne in determinedCategory) {
            if (determinedOne == category)
                count++
        }
        if (count > 2)
            return true
        return false
    }

    private fun determineMenu(determinedCategory: List<String>, cantEat: List<String>): List<String> {
        val determinedMenu = mutableListOf<String>()
        while (determinedMenu.size <= 5) {
            for (category in determinedCategory) {
                val menus = Food.valueOf(category).menu
                val menu: String = Randoms.shuffle(menus)[0]
                if(checkDuplicateMenu(determinedMenu, menu) && checkCantEatFood(menu, cantEat))
                    continue

                determinedMenu.add(menu)
            }
        }
        return determinedMenu
    }

    fun checkDuplicateMenu(determinedMenu: MutableList<String>, menu: String): Boolean {
        if (determinedMenu.contains(menu))
            return true
        return false
    }

    fun checkCantEatFood(menu: String, cantEat: List<String>): Boolean {
        if (cantEat.contains(menu))
            return true
        return false
    }
}