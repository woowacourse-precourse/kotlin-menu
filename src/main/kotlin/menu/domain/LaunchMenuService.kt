package menu.domain

import menu.domain.category.CategoriesGenerator
import menu.domain.menu.MenuGenerator

class LaunchMenuService {

    fun getCategories(categoriesGenerator: CategoriesGenerator): List<Category> {
        val categories = mutableListOf<Category>()
        while (categories.size != CATEGORY_SIZE) {
            val category = categoriesGenerator.generate()
            if (isValidCategory(categories, category)) categories.add(category)
        }
        return categories
    }

    fun isValidCategory(categories: List<Category>, category: Category): Boolean {
        if (categories.count { presentCategory -> presentCategory == category } >= MAX_DUPLICATED_CATEGORY_NUMBER) return false
        return true
    }

    fun getMenus(category: List<Category>, impossibleMenus: List<String>, menuGenerator: MenuGenerator): List<String> {
        val menus = mutableListOf<String>()
        var index = 0
        while (menus.size != MENU_SIZE) {
            val menu = menuGenerator.generate(category[index].food)
            if (isPossibleMenu(impossibleMenus, menu) && isNonDuplicateMenu(menus, menu)) {
                menus.add(menu)
                index++
            }
        }
        return menus
    }

    fun isPossibleMenu(impossibleMenus: List<String>, menu: String): Boolean {
        if (impossibleMenus.contains(menu)) return false
        return true
    }

    fun isNonDuplicateMenu(menus: List<String>, menu: String): Boolean {
        if (menus.contains(menu)) return false
        return true
    }

    fun categoryToString(categories: List<Category>): List<String> {
        val categoriesToString = mutableListOf<String>()
        categories.forEach { category ->
            categoriesToString.add(category.categoryName)
        }
        return categoriesToString
    }

    companion object {
        const val MAX_DUPLICATED_CATEGORY_NUMBER = 2
        const val MENU_SIZE = 5
        const val CATEGORY_SIZE = 5
    }
}