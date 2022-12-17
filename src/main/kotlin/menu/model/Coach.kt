package menu.model

import menu.common.MAX_CANT_EAT_MENU_SIZE

class Coach(private val name: String) {

    private val cantEatMenus = mutableListOf<Menu>()
    private val menuTable = mutableMapOf<DayOfWeek, Menu>()

    fun name(): String = name

    fun addCantEatMenu(menu: Menu) = cantEatMenus.add(menu)

    fun recommendedTooManyCategory(category: Category): Boolean =
        menuTable.values.count { it.getCategory() == category } >= MAX_CANT_EAT_MENU_SIZE
    fun cantEat(menu: Menu): Boolean = cantEatMenus.contains(menu)

    fun recommended(menu: Menu): Boolean = menuTable.values.contains(menu)

    fun recommendMenu(day: DayOfWeek, menu: Menu) {
        menuTable[day] = menu
    }

    fun recommendedCategories(): List<Category> = menuTable.entries.sortedBy { it.key }.map { it.value.getCategory() }

    fun getRecommendedMenu(day: DayOfWeek): Menu = menuTable[day]!!
}