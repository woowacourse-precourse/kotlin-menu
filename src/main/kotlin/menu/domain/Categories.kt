package menu.domain

import menu.WEEK_NUMBER

class Categories {
    private val categories: MutableList<Category> = mutableListOf()

    fun add(): Category {
        check (categories.size <= WEEK_NUMBER) { "카테고리는 최대 ${WEEK_NUMBER}개 만큼만 더할 수 있다." }
        val category = selectCategory()
        categories.add(category)
        return category
    }

    fun joinToString(separator: String): String {
        return categories.joinToString(separator)
    }

    private fun count(category: Category) = categories.count { it == category }

    private fun selectCategory(): Category {
        var category = Category.makeRandomCategory()
        while (count(category) > MAX_DUPLICATED) {
            category = Category.makeRandomCategory()
        }
        return category
    }

    companion object {
        private const val MAX_DUPLICATED = 2
    }
}