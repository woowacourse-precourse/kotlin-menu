package menu.domain

import menu.Category

class Coach(
    private val name: String,
    private val dislike: List<String>,
    private val generator: MenuGenerator
) {
    private val menus = mutableListOf<String>()

    fun recommendMenu(category: Category) {
        var menu = ""
        var success = false
        do {
            menu = generator.generate(category.getMenus())
            if (!isDislikeMenu(menu) && !isAlreadyRecommended(menu)) {
                success = true
            }
        } while (!success)
        menus.add(menu)
    }

    fun getRecommendResult(): List<String> {
        return listOf(name) + menus
    }

    private fun isDislikeMenu(menu: String): Boolean {
        return dislike.contains(menu)
    }

    private fun isAlreadyRecommended(menu: String): Boolean {
        return menus.contains(menu)
    }
}