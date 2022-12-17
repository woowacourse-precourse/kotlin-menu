package menu.domain

data class Menu(val name: String, val category: Category) {

    init {
        if (availableMenus.isNotEmpty()) {
            require(name in menuNames) { "$name not in menu"}
        }
    }

    override fun toString(): String {
        return name
    }

    companion object {
        var availableMenus = listOf<Menu>()
        private val menuNames get() = availableMenus.map { it.name }

        fun from(name: String): Menu {
            return availableMenus.firstOrNull { it.name == name }
                ?: throw IllegalArgumentException("$name not in menu")
        }
    }
}