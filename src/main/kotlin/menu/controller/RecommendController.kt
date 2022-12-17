package menu.controller

import menu.dto.NamesDTO
import menu.view.InputView
import menu.view.OutputView

class RecommendController(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    private lateinit var namesDTO: NamesDTO

    fun startService() {
        outputView.printStart()
        outputView.printInterval()

        setUpCoaches()
    }

    private fun setUpCoaches() {}

    private fun getNames() {
        var success = false
        do {
            try {
                namesDTO = inputView.readNames()
                success = true
            } catch (exception: IllegalArgumentException) {
                outputView.printError(exception.message ?: "")
            }
        } while (!success)
    }
}