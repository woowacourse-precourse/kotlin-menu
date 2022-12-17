package menu.model

class Week() {
    private var categories = mutableListOf<String>()
    private val dayOfWeek = listOf("월요일","화요일","수요일","목요일","금요일")

    fun addMenus(category:String) {
        categories.add(category)
    }

    fun getCategories() = categories

    fun getDayOfWeek() = dayOfWeek

}