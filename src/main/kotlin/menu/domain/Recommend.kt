package menu.domain

import camp.nextstep.edu.missionutils.Randoms
import menu.utils.MAXIMUM_DUPLICATE_CATEGORY_COUNT

class Recommend {
    fun recommendMenu(coach: Coach, category: String): String {
        while (true) {
            val menu = Randoms.shuffle(Menu.getCategoryMenus(category))[0]
            if (coach.getCantEatMenus().contains(menu)) continue
            if (!coach.getRecommendedMenus().contains(menu)) return menu
        }
    }

    fun recommendCategory(categories: List<String>): String {
        while (true) {
            val category = Menu.getCategories(Randoms.pickNumberInRange(1, 5))
            if (checkCategoryAvailable(categories, category)) return category
        }
    }

    private fun checkCategoryAvailable(categories: List<String>, category: String): Boolean {
        var count = 1
        categories.forEach {
            if (it == category) count += 1
        }
        if (count > MAXIMUM_DUPLICATE_CATEGORY_COUNT) return false
        return true
    }
}
