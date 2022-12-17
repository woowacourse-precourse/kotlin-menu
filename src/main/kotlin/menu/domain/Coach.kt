package menu.domain

import menu.Category
import menu.dto.CategoriesDTO

class Coach(
    private val name: String,
    private val dislike: List<String>,
    private val generator: MenuGenerator
) {
    private val menus = mutableListOf<String>()

    fun recommendMenus(categoriesDTO: CategoriesDTO) {
        val categories = categoriesDTO.getCategories()
        categories.map { category ->
            val menu = recommendMenu(category)
        }
    }

    private fun recommendMenu(category: Category): String {
        var menu = ""
        val success = false
        do {
            menu = generator.generate(category.getMenus())
        } while (!success)
        return menu
    }

    private fun isDislikeMenu(menu: String): Boolean {
        return dislike.contains(menu)
    }
}