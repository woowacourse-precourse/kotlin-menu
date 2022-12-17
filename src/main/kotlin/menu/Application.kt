package menu

import menu.controller.DietMenuController
import menu.view.InputView
import menu.view.OutputView

fun main() {
    try {
        val dietMenuController = DietMenuController(
            inputView = InputView(),
            outputView = OutputView()
        )
        dietMenuController.startRecommend()
    } catch (e: Exception) {
        println(e.message)
    }
}
