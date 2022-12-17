package menu.domain

import camp.nextstep.edu.missionutils.Randoms

class MenuRecommend {
    fun recommendMenusToCoach(categories: List<String>, coach: Coach) {
        val menus = mutableListOf<String>()
        for (category in categories) {
            menus.add(recommendCategoryMenu(category, menus, coach))
        }
        coach.setRecommendedMenus(menus)
    }

    private fun recommendCategoryMenu(category: String, recommendMenus: List<String>, coach: Coach): String {
        while (true) {
            val menus = Menus.getCategoryMenus(category)
            val menu = Randoms.shuffle(menus)[0]
            println(menu)
            if (coach.getCantEatMenus().contains(menu)) continue
            if (!recommendMenus.contains(menu)) return menu
        }

    }

    fun recommendCategory(): List<String> {
        val categories = mutableListOf<String>()
        while (categories.size < 5) {
            var category: String
            do {
                category = Menus.getCategories(Randoms.pickNumberInRange(1, 5))
            } while (!checkCategoryAvailable(categories, category))
            categories.add(category)
        }
        return categories
    }

    private fun checkCategoryAvailable(categories: List<String>, category: String): Boolean {
        var count = 1
        categories.forEach {
            if (it == category) count += 1
        }
        if (count > 2) return false
        return true
    }
}