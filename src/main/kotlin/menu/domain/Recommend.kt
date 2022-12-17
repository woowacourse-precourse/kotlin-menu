package menu.domain

import camp.nextstep.edu.missionutils.Randoms
import menu.constants.MAXIMUM_DUPLICATE_CATEGORY_COUNT

class Recommend {
    fun recommendCategoryMenu(category: String, coach: Coach): String {
        while (true) {
            val menus = Menus.getCategoryMenus(category)
            val menu = Randoms.shuffle(menus)[0]
            if (coach.getCantEatMenus().contains(menu)) continue
            if (!coach.getRecommendedMenus().contains(menu)) return menu
        }
    }

    fun recommendCategory(categories: List<String>): String {
        var category: String
        do {
            category = Menus.getCategories(Randoms.pickNumberInRange(1, 5))
        } while (!checkCategoryAvailable(categories, category))
        return category
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