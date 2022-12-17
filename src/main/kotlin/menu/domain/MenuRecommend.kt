package menu.domain

import camp.nextstep.edu.missionutils.Randoms

class MenuRecommend {
    fun recommendToCoach(coach: Coach): List<Int> {
        var oneWeekCategories = recommendCategory()
        return oneWeekCategories
        // 메뉴 겹치지 않게
    }

    private fun recommendCategory(): List<Int> {
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