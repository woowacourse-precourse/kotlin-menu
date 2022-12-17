package menu.domain

import menu.common.Category

private const val CATEGORIES_SIZE = 5

class CategoryCreator {

    fun createCategories(): List<Category> {
        val categories = mutableListOf<Category>()
        repeat(CATEGORIES_SIZE) {
            categories.add(createCategory(categories))
        }
        return categories
    }

    private fun createCategory(categories: List<Category>): Category {
        val category: Category = Category.getRandomCategory()
        if (isNumberOfCategoryMax(category, categories)) {
            return createCategory(categories)
        }
        return category
    }

    private fun isNumberOfCategoryMax(category: Category, categories: List<Category>): Boolean {
        if (categories.count { it == category } >= 2) {
            return true
        }
        return false
    }
}
