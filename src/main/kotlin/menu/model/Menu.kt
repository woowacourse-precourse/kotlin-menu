package menu.model

data class Menu(val name: String) {
    fun getCategory(): Category = Category.values().first { it.menus.contains(this) }
}
