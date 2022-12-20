package menu.model

import camp.nextstep.edu.missionutils.Randoms

class Coach(private val name: String) {

    private val recommendedMenus = mutableListOf<String>()
    private val excludeMenus = mutableListOf<String>()

    fun getName() = name

    fun getExcludeMenus() = excludeMenus

    fun addExcludeMenus(menus: List<String>) {
        menus.forEach { menu ->
            excludeMenus.add(menu)
        }
    }

    fun getRecommendedMenus() = recommendedMenus

    fun addRecommendedMenus(menu: String) {
        recommendedMenus.add(menu)
    }

}