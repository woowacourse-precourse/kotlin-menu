package menu.controller

import menu.model.Category
import menu.model.Coach
import menu.model.Menu

abstract class RecommendMenu {

    abstract fun addRandomCategory(category: Category)

    abstract fun recommendMenu(category: Category, menu: Menu)

}