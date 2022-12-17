package menu

import menu.controller.MenuController

fun main() {
    val menuController = MenuController()
    try {
        menuController.recommendMenu()
    } catch (e: IllegalArgumentException) {
    }
}
