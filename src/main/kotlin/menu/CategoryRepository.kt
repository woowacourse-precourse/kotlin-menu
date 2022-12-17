package menu

import java.util.*

class CategoryRepository {
    private val categories: MutableList<String> = ArrayList()

    fun categories(): List<String> {
        return Collections.unmodifiableList(categories)
    }

    fun addLine(category: String) {
        categories.add(category)
    }
}