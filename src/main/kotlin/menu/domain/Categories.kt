package menu.domain

import menu.WEEK_NUMBER

class Categories {
    private val _selectedCategories: MutableList<Category> = mutableListOf()
    val selectedCategories get() = _selectedCategories as List<Category>

    fun addRandomCategory(): Category {
        check(_selectedCategories.size < WEEK_NUMBER) { ERROR_MAX_LENGTH }
        val category = selectCategory()
        _selectedCategories.add(category)
        return category
    }

    private fun count(category: Category) = _selectedCategories.count { it == category }

    private fun selectCategory(): Category {
        var category = Category.makeRandomCategory()
        while (count(category) > MAX_DUPLICATED) {
            category = Category.makeRandomCategory()
        }
        return category
    }

    companion object {
        private const val MAX_DUPLICATED = 2
        private const val ERROR_MAX_LENGTH = "카테고리는 최대 ${WEEK_NUMBER}개 만큼만 더할 수 있다."
    }
}
