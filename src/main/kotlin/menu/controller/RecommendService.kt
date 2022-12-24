package menu.controller

import menu.model.Coach
import menu.view.InputView
import menu.view.OutputView

class RecommendService {

    private val outputView = OutputView()

    private val inputView = InputView()
    fun execute() {
        outputView.printStart()
        val coachesName = inputView.readCoachesName()
        var coaches = coachesName.map { coachName ->
            val excludedFoods = inputView.readExcludedFoods(coachName)
            Coach(coachName, excludedFoods)
        }
        val recommendMenu = RecommendMenuImpl(coaches)
        outputView.printRecommendResult(recommendMenu.getWeek(), recommendMenu.getCoaches())
        outputView.printEnd()
    }
}