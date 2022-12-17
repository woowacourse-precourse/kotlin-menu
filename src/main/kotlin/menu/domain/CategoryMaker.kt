package menu.domain

import menu.Category
import menu.dto.CategoriesDTO

class CategoryMaker(private val generator: CategoryNumberGenerator) {
    private val count = MutableList(Category.values().size) { 0 }

    fun make(): CategoriesDTO {
        val categories = mutableListOf<Category>()

        do {
            val number = generator.generate() - 1
            if(count[number] < 2) {
                categories.add(Category.values()[number])
                count[number]++
            }
        } while (categories.size != 5)

        return CategoriesDTO(categories)
    }
}