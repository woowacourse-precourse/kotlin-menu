package menu.dto

import menu.Category

class MenusDTO(private val menus: List<String>) {
    init {
        isSizeValid()
        isValidMenu()
    }

    fun getMenus(): List<String> {
        return menus
    }

    private fun isSizeValid() {
        require(menus.size in MIN_SIZE..MAX_SIZE) { SIZE_ERROR_MESSAGE }
    }

    private fun isValidMenu() {
        val validMenus = Category.getAllMenu()
        menus.map { menu -> require(validMenus.contains(menu)) { INVALID_MENU_ERROR_MESSAGE } }
    }

    companion object {
        const val INVALID_MENU_ERROR_MESSAGE = "존재하지 않는 메뉴가 있습니다."
        const val MAX_SIZE = 2
        const val MIN_SIZE = 0
        const val SIZE_ERROR_MESSAGE = "각 코치는 최소 0개, 최대 2개의 못 먹는 메뉴가 있어야 합니다."
    }
}