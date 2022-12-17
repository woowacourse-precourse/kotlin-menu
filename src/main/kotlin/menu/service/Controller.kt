package menu.service

import menu.domain.CoachManager
import menu.view.InputView
import menu.view.OutputView

class Controller {
    private val inputView = InputView()
    private val outputView = OutputView()
    private lateinit var coachManager : CoachManager

    fun start() {
        outputView.printStart()
        outputView.printGetCoach()
        val coachNames = inputView.getCoachNames()
        val unavailableFoods = mutableListOf<List<String>>()
        for (i in coachNames.indices) {
            outputView.printGetUnavailableFood(coachNames[i])
            unavailableFoods.add(inputView.getUnavailableFoods())
        }
        coachManager = CoachManager(coachNames, unavailableFoods)
        coachManager.pickCategory()
        coachManager.pickMenuFifth()

        outputView.printResult(coachManager.getCategoriesDetails(), coachManager.getCoachesDetails())
    }
}