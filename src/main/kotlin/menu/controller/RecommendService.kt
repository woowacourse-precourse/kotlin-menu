package menu.controller

import menu.model.Coach
import menu.view.InputView
import menu.view.OutputView

class RecommendService {

        private val outputView = OutputView()

        private val inputView = InputView()
    fun execute(){
        outputView.printStart()
        val coachesName = inputView.readCoachesName()
        val coaches = coachesName.map { coachName -> Coach(coachName) }
        coaches.map { coach -> coach.addExcludeMenus(inputView.readExcludedFoods(coach.getName())) }
        val week = RecommendMenuImpl(coaches).getWeek()
        outputView.printRecommendResult(week,coaches)
    }
}