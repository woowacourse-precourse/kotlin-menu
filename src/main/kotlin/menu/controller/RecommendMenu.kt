package menu.controller

import menu.model.Category

abstract class RecommendMenu {

    abstract fun isDuplicateCategory(category: Category) : Boolean

    abstract fun chooseRandomCategory()

    abstract fun checkDuplicateMenu()

    abstract fun recommendMenu()

}