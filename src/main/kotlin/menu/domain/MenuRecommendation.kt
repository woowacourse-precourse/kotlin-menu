package menu.domain

import menu.view.InputView
import menu.view.OutputView

class MenuRecommendation(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    private lateinit var coachName: List<String>

    fun start() {
        outputView.printStart()
        coachName = inputCoachName()
    }

    fun inputCoachName(): List<String> {
        while (true) {
            try {
                return inputView.readCoachName()
            } catch (e: IllegalArgumentException) {
                println(e.message)
                continue
            }
        }
    }
}