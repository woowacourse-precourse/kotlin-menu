package menu.model

import camp.nextstep.edu.missionutils.Randoms

class Coach(private val name: String) {

    private val recommendedMenus = mutableListOf<String>()

    fun getName() = name

    fun getRecommendedMenus() = recommendedMenus

    fun addRecommendedMenus(menu: String) {
        recommendedMenus.add(menu)
    }

}