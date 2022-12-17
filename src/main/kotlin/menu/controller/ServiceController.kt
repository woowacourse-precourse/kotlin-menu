package menu.controller

import menu.view.InputView
import menu.view.OutputView

class ServiceController(
    private val inputView: InputView,
    private val outputView: OutputView
) {

    fun run() {
        getValidatedInput()
    }

    private fun getValidatedInput(): Int {
        while (true) {
            try {
                return inputView.read()
            } catch (e: IllegalArgumentException) {
                outputView.printErrorMessage(e)
            }
        }
    }

}
