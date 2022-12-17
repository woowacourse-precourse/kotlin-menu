package menu.domain

class Coach(val name: String) {

    private val hateMenus: MutableList<Menu> = mutableListOf()
    private val _selectedMenus = mutableListOf<Menu>()
    val selectedMenus get() = _selectedMenus as List<Menu>

    init {
        require(name.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH) { ERROR_NAME_LENGTH }
    }

    fun addSelectedMenu(menu: Menu): Boolean {
        if (isHateMenu(menu)) return false
        return _selectedMenus.add(menu)
    }

    fun addHateMenu(menu: Menu) {
        require(menu !in hateMenus) { "중복된 메뉴입니다." }
        require(hateMenus.size < MAX_HATE_LENGTH) { "못 먹는 음식은 최대 2개입니다." }
        hateMenus.add(menu)
    }

    private fun isHateMenu(menu: Menu) = menu in hateMenus

    companion object {
        private const val MAX_NAME_LENGTH = 4
        private const val MIN_NAME_LENGTH = 2
        private const val MAX_HATE_LENGTH = 2

        private const val ERROR_NAME_LENGTH = "이름 길이가 ${MIN_NAME_LENGTH}이상 ${MAX_NAME_LENGTH}가 아닙니다."
    }
}
