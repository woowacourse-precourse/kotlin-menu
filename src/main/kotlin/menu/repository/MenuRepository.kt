package menu.repository

import menu.domain.MenuCategory

class MenuRepository {
    // 요일별 코치들 추천 메뉴
    private val coachesRecommendedFoods = HashMap<Int, LinkedHashMap<String, String>>()
    private val categoriesCount = HashMap<String, Int>()

    fun getAllCategoryAsString(): List<String> = MenuCategory.getAllCategoryAsString()

    fun getCategory(categoryName: String) = MenuCategory.convert(categoryName)

    fun isRecommendedAlready(menu: String, coach: String): Boolean {
        coachesRecommendedFoods.forEach { (_, foods) ->
            if (foods[coach] == menu) {
                return true
            }
        }
        return false
    }

    fun plusCategoryCount(categoryName: String) {
        val originCategoryCount = categoriesCount.getOrPut(categoryName) { DEFAULT_CATEGORY_COUNT }
        categoriesCount[categoryName] = originCategoryCount
    }

    fun getCoachRecommendedMenus() = coachesRecommendedFoods

    fun getCategoriesCount(categoryName: String): Int {
        return categoriesCount[categoryName] ?: DEFAULT_CATEGORY_COUNT
    }

    fun putMenu(day: Int, coaches: List<String>, recommendedFoods: List<String>) {
        val foods = linkedMapOf<String, String>()
        for (index in coaches.indices) {
            foods[coaches[index]] = recommendedFoods[index]
        }
        coachesRecommendedFoods[day] = foods
    }

    companion object {
        private const val DEFAULT_CATEGORY_COUNT = 0
    }
}