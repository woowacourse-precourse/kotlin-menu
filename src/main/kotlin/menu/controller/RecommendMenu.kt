package menu.controller

import menu.model.Category
import menu.model.Coach
import menu.model.Menu

abstract class RecommendMenu {

    abstract fun isDuplicateCategory(category: Category): Boolean

    abstract fun addRandomCategory()

    abstract fun isDuplicateMenu(coach: Coach, menu: String): Boolean

    abstract fun recommendMenu(coachs: List<Coach>, category: Category, menu: Menu)

}