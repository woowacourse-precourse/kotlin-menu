package menu.domain

import menu.utils.ERROR
import menu.utils.ERROR_MENUS_SIZE
import menu.utils.MAX_MENUS_SIZE

import menu.utils.MIN_MENUS_SIZE

class Menus(private val values: List<String>) {

    init {
        require(isSize()) { ERROR.format(ERROR_MENUS_SIZE) }
    }

    fun getMenus(): List<Menu> =
        values.map { name ->
            Menu(name)
        }

    private fun isSize(): Boolean =
        values.size >= MIN_MENUS_SIZE && values.size <= MAX_MENUS_SIZE
}