package menu.model

class Week {
    private val categoriesName = mutableListOf<String>()

    fun addCategory(category: String) {
        categoriesName.add(category)
    }

    fun getCategories() = categoriesName

}