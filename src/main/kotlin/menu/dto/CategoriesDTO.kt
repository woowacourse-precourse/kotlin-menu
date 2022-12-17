package menu.dto

import menu.Category

class CategoriesDTO(private val categories: List<Category>) {
    fun getCategories(): List<Category> {
        return categories
    }
}