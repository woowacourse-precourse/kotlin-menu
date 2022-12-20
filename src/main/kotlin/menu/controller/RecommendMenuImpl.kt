package menu.controller

import menu.model.Category
import menu.model.Week

class RecommendMenuImpl : RecommendMenu() {
    private val week = Week()
    override fun isDuplicateCategory(category: Category): Boolean {
        return week.getCategories().count { category -> category == category } > 3
    }

    override fun chooseRandomCategory() {

    }

    override fun checkDuplicateMenu() {
        TODO("Not yet implemented")
    }

    override fun recommendMenu() {
        TODO("Not yet implemented")
    }

}