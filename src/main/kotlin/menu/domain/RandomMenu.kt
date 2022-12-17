package menu.domain

import camp.nextstep.edu.missionutils.Randoms

class RandomMenu {
    private val menus = FoodCategory.values()

    fun getRandomMenu(category: FoodCategory): MutableList<String> {
        return Randoms.shuffle(menus[category.ordinal].menuList)
    }
}
