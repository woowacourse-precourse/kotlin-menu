package menu.controller

import menu.model.Coach
import menu.view.OutputView

class RecommendSimulator(
    private val input: InputValidator,
    private val output: OutputView,
) {
    init {
        output.printStartRecommend()
    }
    fun run() {
        val coach = getCoach()

    }

    private fun getCoach(): Coach {
        try {
            output.printRequestName()
            return input.getValidatedCoach()

        } catch (e: IllegalArgumentException) {
            throw e
        }
    }
}