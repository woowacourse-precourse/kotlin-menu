package menu.domain

import menu.view.InputView
import menu.view.OutputView

class MenuRecommendation(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun start() {
        outputView.printStart()
    }
}