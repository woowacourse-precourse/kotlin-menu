package menu.domain

class Coach(private val name: String, private val hateMenus: List<Menu>) {

    init {
        require(name.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH)
        require(hateMenus.size in MIN_HATE_LENGTH..MAX_HATE_LENGTH)
    }

    fun isHateMenu(menu: Menu) = menu in hateMenus

    companion object {
        private const val MAX_NAME_LENGTH = 4
        private const val MIN_NAME_LENGTH = 2
        private const val MIN_HATE_LENGTH = 0
        private const val MAX_HATE_LENGTH = 2
    }
}