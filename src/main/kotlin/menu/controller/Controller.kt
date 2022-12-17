package menu.controller

import menu.domain.Coach
import menu.view.InputView
import menu.view.OutputView

class Controller(
    private val outputView: OutputView,
    private val inputView: InputView
) {
    private val coaches = mutableSetOf<Coach>()

    fun start() {
        outputView.showStart()
    }
}
