package menu.domain

import camp.nextstep.edu.missionutils.Randoms

class MenuRecommend {
    fun recommendMenusToCoach(categories: List<Int>, coach: Coach) {
        // categories[0] == 월요일
        val menus = mutableListOf<String>()
        for (category in categories) {
            menus.add(recommendCategoryMenu(category, menus, coach))
        }
        coach.setRecommendedMenus(menus)
    }

    private fun recommendCategoryMenu(category: Int, recommendMenus: List<String>, coach: Coach): String {
        val menu = Menu()
        while (true) {
            val recommendMenu = Randoms.shuffle(menu.getCategoryMenus(category))[0]
            if (coach.getCantEatMenus().contains(recommendMenu)) continue
            if (!recommendMenus.contains(recommendMenu)) return recommendMenu
        }

    }

    fun recommendCategory(): List<Int> {
        // 같은 카테고리는 최대 2회
        val categories = mutableListOf<Int>()
        while (categories.size < 5) {
            var category: Int
            do {
                category = Randoms.pickNumberInRange(1, 5)
            } while (!checkCategoryAvailable(categories, category))
            categories.add(category)
        }
        return categories
    }

    private fun checkCategoryAvailable(categories: List<Int>, category: Int): Boolean {
        var count = 1
        categories.forEach {
            if (it == category) count += 1
        }
        if (count > 2) return false
        return true
    }
}