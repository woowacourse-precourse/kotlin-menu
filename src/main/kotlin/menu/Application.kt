package menu

import menu.controller.Controller
import menu.controller.MenuController
import menu.service.MenuService
import menu.view.InputView
import menu.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val menuService = MenuService()
    val menuController: Controller = MenuController(inputView, outputView, menuService)

    menuController.run()
}
