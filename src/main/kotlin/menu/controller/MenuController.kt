package menu.controller

import menu.service.MenuService
import menu.view.InputView
import menu.view.OutputView

class MenuController(
    inputView: InputView,
    outputView: OutputView,
    menuService: MenuService
) : Controller(inputView, outputView) {
    override fun run() {
        printStartMessage()
        println(inputCoaches())
    }

    private fun printStartMessage() {
        outputView.printStartMessage()
    }

    private fun inputCoaches(): List<String> = repeat(inputView::inputCoaches)
}