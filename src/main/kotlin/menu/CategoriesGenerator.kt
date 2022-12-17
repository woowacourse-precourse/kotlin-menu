package menu

import menu.domain.Category

interface CategoriesGenerator {
    fun generate(): Category
}