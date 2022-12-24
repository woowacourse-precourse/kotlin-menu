package menu.controller

import menu.model.Category
import menu.model.Coach
import menu.model.Menu

abstract class RecommendMenu {


    abstract fun addRandomCategory(category: Category)

    abstract fun isDuplicateMenu(coach: Coach, menu: String): Boolean

    abstract fun recommendMenu(coaches: List<Coach>, category: Category, menu: Menu)

}