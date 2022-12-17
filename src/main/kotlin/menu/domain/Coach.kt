package menu.domain

class Coach(val name: String, private val hateMenus: MutableList<Menu> = mutableListOf()) {

    val selectedMenus = mutableListOf<Menu>()

    init {
        require(name.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH)
        require(hateMenus.size in MIN_HATE_LENGTH..MAX_HATE_LENGTH)
    }

    fun selectMenu(menu: Menu): Boolean {
        if (isHateMenu(menu)) return false
        return selectedMenus.add(menu)
    }

    fun addHateMenu(menu: Menu) {
        require(menu !in hateMenus)
        require(hateMenus.size < MAX_HATE_LENGTH)
        hateMenus.add(menu)
    }

    private fun isHateMenu(menu: Menu) = menu in hateMenus

    companion object {
        private const val MAX_NAME_LENGTH = 4
        private const val MIN_NAME_LENGTH = 2
        private const val MIN_HATE_LENGTH = 0
        private const val MAX_HATE_LENGTH = 2
    }
}