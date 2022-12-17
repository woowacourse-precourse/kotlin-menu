package menu

import menu.controller.MenuController
import menu.view.InputView
import menu.view.OutputView

fun main() {
    val menuController = initController()
    menuController.inputCoachInfo()
    menuController.recommendWeeklyMenuList()
}

private fun initController(): MenuController {
    val inputView = InputView()
    val outputView = OutputView()
    return MenuController(inputView, outputView)
}
