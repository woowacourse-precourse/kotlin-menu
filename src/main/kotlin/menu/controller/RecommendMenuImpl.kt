package menu.controller

import menu.model.Category
import menu.model.RandomNumberGenerator
import menu.model.Week

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

    override fun checkDuplicateMenu() {
        TODO("Not yet implemented")
    }

    override fun recommendMenu() {
        TODO("Not yet implemented")
    }

}