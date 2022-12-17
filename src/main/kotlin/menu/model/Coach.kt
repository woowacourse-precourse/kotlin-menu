package menu.model

import menu.common.MAX_CANT_EAT_MENU_SIZE
import menu.common.MAX_COACH_NAME_SIZE
import menu.common.MIN_COACH_NAME_SIZE

class Coach(private val name: String) {

    private val cantEatMenus = mutableListOf<Menu>()
    private val menuTable = mutableMapOf<DayOfWeek, Menu>()

    init {
        require(name.length in MIN_COACH_NAME_SIZE..MAX_COACH_NAME_SIZE) { "코치의 이름의 길이는 2 이상 4 이하여야 합니다." }
    }

    fun name(): String = name

    fun addCantEatMenu(menu: Menu) {
        require(!cantEatMenus.contains(menu)) { "이미 못 먹는 메뉴입니다." }
        cantEatMenus.add(menu)
    }

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