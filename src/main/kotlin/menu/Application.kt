package menu

import menu.controller.MenuController
import menu.domain.Category
import menu.domain.Menu

fun main() {
    setAvailableMenus()
    MenuController().run()
}

private fun setAvailableMenus() {
    val lines = AVAILABLE_MENUS.split("\n")
    val availableMenus = mutableListOf<Menu>()
    for (line in lines) {
        val categoryAndMenus = line.split(":")
        val category = Category.from(categoryAndMenus[0])
        val menus = categoryAndMenus[1].split(",").map { Menu(it.trim(), category) }
        availableMenus.addAll(menus)
    }
    Menu.availableMenus = availableMenus
}
