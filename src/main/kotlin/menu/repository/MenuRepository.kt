package menu.repository

import menu.domain.MenuCategory

class MenuRepository {
    private val foodCategories = arrayListOf<MenuCategory>()
    private val coachesRecommendedFoods = linkedMapOf<String, List<String>>()

    fun getAllCategoryAsString(): List<String> = MenuCategory.getAllCategoryAsString()

    fun getCategory(categoryName: String) = MenuCategory.convert(categoryName)

    fun getRecommendedFoodsSize(coach: String) = coachesRecommendedFoods[coach]?.size ?: 0

    fun getRecommendFoods(coach: String) = coachesRecommendedFoods[coach] ?: emptyList()

    fun getCoachRecommendedMenus() = coachesRecommendedFoods

    fun getRecommendedSizePerCategories(coach: String): Map<MenuCategory, Int> {
        val recommendedSizePerCategories = hashMapOf<MenuCategory, Int>()
        val recommendedFoods = getRecommendFoods(coach)
        recommendedFoods.forEach { food ->
            val allCategory = MenuCategory.getAllCategory()
            allCategory.forEach { category ->
                val isContain = category.isContain(food)
                if (isContain) {
                    val originSize = recommendedSizePerCategories.getOrPut(category) { 0 }
                    recommendedSizePerCategories[category] = originSize + 1
                }
            }
        }
        return recommendedSizePerCategories
    }

    fun getCategoryByMenu(menu: String): MenuCategory? {
        val allCategory = MenuCategory.getAllCategory()
        allCategory.forEach { category ->
            if (category.isContain(menu)) {
                return category
            }
        }
        return null
    }

    fun putMenu(coach: String, food: String) {
        val recommendedFoods = ArrayList(getRecommendFoods(coach))
        recommendedFoods.add(food)
        coachesRecommendedFoods[coach] = recommendedFoods
    }
}