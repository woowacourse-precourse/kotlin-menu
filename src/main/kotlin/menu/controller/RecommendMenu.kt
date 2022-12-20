package menu.controller

import menu.model.Category
import menu.model.Coach

abstract class RecommendMenu {

    abstract fun isDuplicateCategory(category: Category): Boolean

    abstract fun addRandomCategory()

    abstract fun isDuplicateMenu(coach: Coach, menu: String): Boolean

    abstract fun recommendMenu()

}