package menu.domain

class Coach(val name: String) {
    private lateinit var cantEatMenus: List<String>

    fun setCantEatMenus(menus: List<String>) {
        cantEatMenus = menus
    }

    fun getCantEatMenus(): List<String> {
        return cantEatMenus
    }
}