package menu.domain.category

import menu.domain.Category

interface CategoriesGenerator {
    fun generate(): Category
}