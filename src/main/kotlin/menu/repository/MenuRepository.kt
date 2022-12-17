package menu.repository

import menu.domain.MenuCategory

class MenuRepository {
    private val foodCategories = arrayListOf<MenuCategory>()

    fun getAllCategoryAsString(): List<String> = MenuCategory.getAllCategory()

    fun getCategory(categoryName: String) = MenuCategory.convert(categoryName)
}