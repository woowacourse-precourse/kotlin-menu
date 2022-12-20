package menu.model

class Week {
    private val categories = mutableListOf<Category>()

    fun addCategory(category: Category) {
        categories.add(category)
    }

    fun getCategories() = categories

}