package menu.controller

import menu.view.InputView
import menu.view.OutputView

class RecommendController(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun startService() {
        outputView.printStart()
        outputView.printInterval()

        setUpCoaches()
    }

    private fun setUpCoaches() {}
}