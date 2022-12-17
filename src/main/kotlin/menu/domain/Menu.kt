package menu.domain

data class Menu(val name: String, val category: Category) {

    init {
        if (existMenus.isNotEmpty()) {
            require(name in existMenuNames) { "$name not in menu" }
        }
    }

    override fun toString(): String {
        return name
    }

    companion object {
        var existMenus = listOf<Menu>()
        private val existMenuNames get() = existMenus.map { it.name }

        fun from(name: String): Menu {
            return existMenus.firstOrNull { it.name == name }
                ?: throw IllegalArgumentException("$name not in menu")
        }
    }
}
