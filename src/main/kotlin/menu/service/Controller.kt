package menu.service

import menu.domain.CoachManager
import menu.view.InputView
import menu.view.OutputView

class Controller {
    private val inputView = InputView()
    private val outputView = OutputView()
    private lateinit var coachManager: CoachManager

    fun run() {
        val coachNames = getCoachNames()
        val unavailableFoods = getUnavailableFood(coachNames)
        pickMenuPerCoach(coachNames, unavailableFoods)
        showResult()
    }

    private fun getCoachNames(): List<String> {
        outputView.printStart()
        outputView.printGetCoach()
        return inputView.getCoachNames()
    }

    private fun getUnavailableFood(coachNames: List<String>): MutableList<List<String>> {
        val unavailableFoods = mutableListOf<List<String>>()
        for (i in coachNames.indices) {
            outputView.printGetUnavailableFood(coachNames[i])
            unavailableFoods.add(inputView.getUnavailableFoods())
        }
        return unavailableFoods
    }

    private fun pickMenuPerCoach(coachNames: List<String>, unavailableFoods: MutableList<List<String>>) {
        coachManager = CoachManager(coachNames, unavailableFoods)
        coachManager.pickCategory()
        coachManager.pickMenuFifth()
    }

    private fun showResult() {
        outputView.printResult(coachManager.getCategoriesDetails(), coachManager.getCoachesDetails())
    }
}