package menu.model

import camp.nextstep.edu.missionutils.Randoms
import menu.data.*

class MenuRecommender {
    private val menuList = MenuList()
    fun generateWeekCategory(): List<Category> {
        val categories = mutableListOf<Category>()

        while (categories.size < 5) {
            val category = Category.values()[Randoms.pickNumberInRange(1, 5) - 1]
            if (validateCategory(categories, category)) continue
            categories.add(category)
        }

        return categories
    }

    private fun validateCategory(categories: List<Category>, category: Category): Boolean {
        if (categories.count { it == category } >= 2)
            return true
        return false
    }

    private fun generateMenuByCoach(coach: Coach, menus: List<Menu>, categories: List<Category>, dayOfWeek: Int): Menu {
        if (categories.size != 5 || dayOfWeek < 0 || dayOfWeek > 4)
            throw IllegalStateException(Message.ERR_MENU_ARGUMENT)
        while (true) {
            val menusByCategory = menuList.getMenus()[categories[dayOfWeek]]
            val menuNamesByCategory = menusByCategory!!.map { it.toString() }
            val menu = Menu(Randoms.shuffle(menuNamesByCategory)[0])
            if (validateMenu(coach, menu, menus)) continue
            return menu
        }
    }

    private fun validateMenu(coach: Coach, menu: Menu, menus: List<Menu>): Boolean {
        if (coach.validateMenu(menu))
            return true
        if (menus.contains(menu))
            return true
        return false
    }

    fun getRecommendation(
        categories: List<Category>,
        coaches: List<Coach>
    ): Map<Coach, List<Menu>> {
        val menusByCoaches = mutableMapOf<Coach, MutableList<Menu>>()
        for (i in 0..4) {
            getDayRecommendation(menusByCoaches, categories, coaches, i)
        }
        return menusByCoaches
    }

    private fun getDayRecommendation(
        menusByCoaches: MutableMap<Coach, MutableList<Menu>>,
        categories: List<Category>,
        coaches: List<Coach>, dayOfWeek: Int
    ) {
        for (coach in coaches) {
            getCoachRecommendation(menusByCoaches, categories, dayOfWeek, coach)
        }
    }

    private fun getCoachRecommendation(
        menusByCoaches: MutableMap<Coach, MutableList<Menu>>,
        categories: List<Category>, dayOfWeek: Int, coach: Coach
    ) {
        if (menusByCoaches[coach] == null)
            menusByCoaches[coach] = mutableListOf()
        val menu = generateMenuByCoach(coach, menusByCoaches[coach]!!, categories, dayOfWeek)
        menusByCoaches[coach]?.add(menu)
    }
}