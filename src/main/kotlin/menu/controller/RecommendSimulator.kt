package menu.controller

import menu.domain.MenuGenerator
import menu.model.Coach
import menu.model.Food
import menu.view.OutputView

class RecommendSimulator(
    private val input: InputValidator,
    private val output: OutputView,
) {
    init {
        output.printStartRecommend()
    }
    fun run() {
        val coachList = getCoach()
        coachList.getCoach().forEach {
            coach -> val food = getFood(coach)
            MenuGenerator(food)
        }

    }

    private fun getCoach(): Coach {
        try {
            output.printRequestName()
            return input.getValidatedCoach()

        } catch (e: IllegalArgumentException) {
            throw e
        }
    }

    private fun getFood(coach: String): Food {
        try {
            output.printRequestFood(coach)
            return input.getValidatedFood()

        } catch (e: IllegalArgumentException) {
            throw e
        }
    }
}