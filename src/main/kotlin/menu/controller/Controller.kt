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

    fun inputNames() {
        try {
            outputView.requestInputName()
            createCoaches(inputView.readCoachesName())
        } catch (e: IllegalArgumentException) {
            outputView.showErrorMessage(e.message ?: "")
            inputNames()
        }
    }

    private fun createCoaches(names: List<String>) {
        names.forEach {
            coaches.add(Coach(it))
        }
    }
}
