package menu

class Coach(private val name: String) {
    private var bias = listOf<String>()
    private var menus = mutableListOf<String>()
    private var categories = mutableListOf(0, 0, 0, 0, 0)

    fun getName() = this.name

    fun getCategoriesCount(index: Int) = categories[index - 1]

    fun getRecommendedMenu() = menus

    fun saveBias(input: List<String>) {
        bias = input
    }

    fun saveRecommendMenus(input: String) {
        menus.add(input)
    }
}