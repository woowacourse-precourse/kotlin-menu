package menu.data

class Coach(private val name: String) {
    private var bias = listOf<String>()
    private var menus = mutableListOf<String>()

    fun getName() = this.name

    fun getRecommendedMenu() = menus

    fun saveBias(input: List<String>) {
        bias = input
    }

    fun saveRecommendMenus(input: String) {
        menus.add(input)
    }
}