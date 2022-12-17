package menu

import menu.view.InputView
import menu.view.OutputView

class RecommendMenu() {
    fun run() {
        OutputView().printStartMessage()
        val coaches = InputView().getCoaches()
    }
}