package menu.model

import camp.nextstep.edu.missionutils.Randoms

class Coach(private val name: String) {

    private val recommendedMenus = mutableListOf<String>()

    fun getName() = name

    fun getRecommendedMenus() = recommendedMenus

    fun addRecommendedMenus(category: Category, menu: Menu) {
        recommendedMenus.add(Randoms.shuffle(menu.getCategoryMenu(category.getCategoryName()))[0])
    }

}