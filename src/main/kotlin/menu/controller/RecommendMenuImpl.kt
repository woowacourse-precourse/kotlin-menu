package menu.controller

import menu.model.*

class RecommendMenuImpl : RecommendMenu() {
    private val week = Week()
    private val randomNumberGenerator = RandomNumberGenerator()
    override fun isDuplicateCategory(category: Category): Boolean {
        return week.getCategories().count { category -> category == category } > 3
    }

    override fun addRandomCategory() {
        val categoriesName = Category.values().map { category -> category.getCategoryName() }
        week.addCategory(categoriesName[randomNumberGenerator.generator()])
    }

    override fun isDuplicateMenu(coach: Coach, menu: String): Boolean {
        return coach.getRecommendedMenus().contains(menu)
    }

    override fun recommendMenu(coachs: List<Coach>, category: Category, menu: Menu) {
        coachs.forEach { coach -> coach.addRecommendedMenus(category, menu) }
    }

}