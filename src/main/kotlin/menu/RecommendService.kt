package menu

import menu.view.InputView
import menu.view.OutputView

class RecommendService {
    fun run() {
        OutputView().printStartMessage()
        val coaches = InputView().getCoaches()
        val categories = mutableListOf<String>()
    }
}