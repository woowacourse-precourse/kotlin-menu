package menu

import camp.nextstep.edu.missionutils.Randoms

class MenuRecommender {
    fun makeMenus(coaches: List<Coach>): MenuResult {
        val categories = makeCategories()
        val recommendations = makeRecommendations(categories, coaches)
        return MenuResult(categories, recommendations)
    }

    private fun convertCategory(number: Int): Category {
        return when (number) {
            1 -> Category.일식
            2 -> Category.한식
            3 -> Category.중식
            4 -> Category.아시안
            5 -> Category.양식
            else -> {
                Category.전부
            }
        }
    }

    private fun makeCategories(): List<Category> {
        val categories = mutableListOf<Category>()
        while (categories.size < 5) {
            val category = convertCategory(Randoms.pickNumberInRange(1, 5))
            val count = categories.count { it == category }
            if (count < 2) categories.add(category)
        }
        return categories
    }

    private fun getEatableMenu(recommendation: List<String>, category: Category, coach: Coach): String {
        var menu: String
        do {
            menu = Randoms.shuffle(category.menus)[0]
        } while (coach.isUneatable(menu) || recommendation.contains(menu))
        return menu
    }

    private fun makeRecommendations(categories: List<Category>, coaches: List<Coach>): Map<String, List<String>> {
        val recommendations = mutableMapOf<String, MutableList<String>>()
        for (coach in coaches) {
            recommendations[coach.name] = mutableListOf()
        }
        for (category in categories) {
            for (coach in coaches) {
                recommendations[coach.name]!!.add(getEatableMenu(recommendations[coach.name]!!.toList(), category, coach))
            }
        }
        return recommendations
    }
}