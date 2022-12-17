package menu

import camp.nextstep.edu.missionutils.Randoms

class MenuRecommender {
    private val menuList = MenuList()
    fun generateWeekCategory(): List<Category> {
        val categories = mutableListOf<Category>()

        while (categories.size < 5) {
            val category = Category.values()[Randoms.pickNumberInRange(1, 5) - 1]
            if (validateCategory(categories, category))
                continue
            categories.add(category)
        }

        return categories
    }

    private fun validateCategory(categories: List<Category>, category: Category): Boolean {
        if (categories.count { it == category } >= 2)
            return true
        return false
    }

    fun generateMenuByCoach(coach: Coach, category: Category): List<Menu> {
        val menus = mutableListOf<Menu>()

        while (menus.size < 5) {
            val menu = Randoms.shuffle(menuList.getMenus()[category])[0]
            if (validateMenu(coach, menu, menus))
                continue
            menus.add(menu)
        }

        return menus
    }

    private fun validateMenu(coach: Coach, menu: Menu, menus: List<Menu>): Boolean {
        if (coach.validateMenu(menu))
            return true
        if (menus.contains(menu))
            return true
        return false
    }
}