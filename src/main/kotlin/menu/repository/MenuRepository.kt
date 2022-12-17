package menu.repository

import menu.domain.MenuCategory

class MenuRepository {
    private val foodCategories = arrayListOf<MenuCategory>()
    private val coachesRecommendedFoods = linkedMapOf<String, List<String>>()

    fun getAllCategoryAsString(): List<String> = MenuCategory.getAllCategory()

    fun getCategory(categoryName: String) = MenuCategory.convert(categoryName)

    fun getRecommendedFoodsSize(coach: String) = coachesRecommendedFoods[coach]?.size ?: 0

    fun getRecommendFoods(coach: String) = coachesRecommendedFoods[coach] ?: emptyList()

    fun putMenu(coach: String, food: String) {
        val recommendedFoods = ArrayList(getRecommendFoods(coach))
        recommendedFoods.add(food)
        coachesRecommendedFoods[coach] = recommendedFoods
    }
}