package menu.domain

class Coach(val name: String) {
    private lateinit var cantEatMenus: List<String>

    // 카테고리(1~5), 메뉴 순서로 저장
    private val recommendedMenus = mutableListOf<List<String>>()

    fun setCantEatMenus(menus: List<String>) {
        cantEatMenus = menus
    }

    fun getCantEatMenus(): List<String> {
        return cantEatMenus
    }

    fun addRecommendedMenus(category: String, menu: String) {
        recommendedMenus.add(listOf(category, menu))
    }

    fun getRecommendedMenus(): List<List<String>> {
        return recommendedMenus
    }
}