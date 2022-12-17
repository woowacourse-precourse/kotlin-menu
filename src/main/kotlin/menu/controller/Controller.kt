package menu.controller

import menu.utils.RepeatInputProcess
import menu.view.InputView
import menu.view.OutputView

class Controller {
    private val outputView = OutputView()
    private val inputView = InputView()

    init {
        outputView.printStartMent()
    }

    fun operate() {
        readNames()
    }

    private fun readNames(): List<String> {
        outputView.printInputCoachNamesMent()
        @Suppress("UNCHECKED_CAST")
        return RepeatInputProcess.repeat { inputView.readCoachNames() } as List<String>
    }
}