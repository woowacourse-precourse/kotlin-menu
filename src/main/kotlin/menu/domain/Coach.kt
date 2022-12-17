package menu.domain

class Coach(val name: String) {
    private lateinit var cantEatMenus: List<String>

    // 카테고리(1~5), 메뉴 순서로 저장
    private lateinit var recommendedMenus : List<String>

    fun setCantEatMenus(menus: List<String>) {
        cantEatMenus = menus
    }

    fun getCantEatMenus(): List<String> {
        return cantEatMenus
    }

    fun setRecommendedMenus(menus:List<String>) {
        recommendedMenus = menus
    }

    fun getRecommendedMenus(): List<String>{
        return recommendedMenus
    }
}