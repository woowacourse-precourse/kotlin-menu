package menu.domain

class Coach(val name: String) {
    private lateinit var cantEatMenus: List<String>
    private val recommendedMenus = mutableListOf<String>()

    fun setCantEatMenus(menus: List<String>) {
        cantEatMenus = menus
    }

    fun getCantEatMenus(): List<String> {
        return cantEatMenus
    }

    fun addRecommendedMenus(menu: String) {
        recommendedMenus.add(menu)
    }

    fun getRecommendedMenus(): List<String> {
        return recommendedMenus
    }
}
