package menu

import menu.controller.MenuController

fun main() {
    val menuController = MenuController()
    menuController.standByPhase()
    menuController.mainPhase()
    menuController.endPhase()
}
