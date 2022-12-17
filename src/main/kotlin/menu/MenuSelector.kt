package menu

import camp.nextstep.edu.missionutils.Randoms

class MenuSelector {
    fun generateWeekCategory(): List<Category> {
        val categories = mutableListOf<Category>()

        while (categories.size < 5) {
            val category = Category.values()[Randoms.pickNumberInRange(1, 5) - 1]
            if (validateCategory(categories, category))
                continue
            categories.add(category)
        }

        return categories
    }

    private fun validateCategory(categories: List<Category>, category: Category): Boolean {
        if (categories.count { it == category } >= 2)
            return true
        return false
    }
}