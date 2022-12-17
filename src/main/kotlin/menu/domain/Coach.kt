package menu.domain

class Coach(val name: String) {
    private lateinit var cantEatMenus: List<String>

    private lateinit var recommendedMenus: List<String>

    fun setCantEatMenus(menus: List<String>) {
        cantEatMenus = menus
    }

    fun getCantEatMenus(): List<String> {
        return cantEatMenus
    }

    fun setRecommendedMenus(menus: List<String>) {
        recommendedMenus = menus
    }

    fun getRecommendedMenus(): List<String> {
        return recommendedMenus
    }
}