package menu.controller

import camp.nextstep.edu.missionutils.Randoms
import menu.Food

class MenuController {
    fun determineWholeMenu(
        determinedCategory: Food, cannotEatFood: List<List<String>>,
        determinedMenu: MutableList<List<String>>
    ): MutableList<String> {
        val result = mutableListOf<String>()
        for (cantEat in cannotEatFood)
            result.add(retryForRightMenu(determinedCategory.menu, determinedMenu, cantEat))
        return result
    }

    private fun retryForRightMenu(
        menus: List<String>, determinedMenu: MutableList<List<String>>, cantEat: List<String>
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