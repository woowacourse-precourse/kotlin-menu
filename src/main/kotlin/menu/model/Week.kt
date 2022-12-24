package menu.model

class Week {

    private val dayOfWeek = listOf("월요일","화요일","수요일","목요일","금요일")
    private val categoriesName = mutableListOf<String>()

    fun addCategory(category: String) {
        if(categoriesName.count { categoryName -> categoryName == category } <= 2) {
            categoriesName.add(category)
        }
    }

    fun getCategories() = categoriesName

    fun getDayOfWeek() = dayOfWeek
}