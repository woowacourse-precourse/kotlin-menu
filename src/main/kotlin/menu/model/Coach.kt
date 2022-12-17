package menu.model

class Coach(private val name: String) {

    private lateinit var cantEatMenus: List<Menu>
    private val menuTable = mutableMapOf<DayOfWeek, Menu>()

    fun name(): String = name

    fun setCantEatMenus(menus: List<Menu>) {
        cantEatMenus = menus
    }

    fun recommendedTooManyCategory(category: Category): Boolean =
        menuTable.values.count { it.getCategory() == category } >= 2
    fun cantEat(menu: Menu): Boolean = cantEatMenus.contains(menu)

    fun recommended(menu: Menu): Boolean = menuTable.values.contains(menu)

    fun recommendMenu(day: DayOfWeek, menu: Menu) {
        menuTable[day] = menu
    }

    fun recommendedCategories(): List<Category> = menuTable.entries.sortedBy { it.key }.map { it.value.getCategory() }

    fun getRecommendedMenu(day: DayOfWeek): Menu = menuTable[day]!!
}