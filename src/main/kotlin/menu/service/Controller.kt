package menu.service

import menu.domain.LogicManager
import menu.view.InputView
import menu.view.OutputView

class Controller {
    private val inputView = InputView()
    private val outputView = OutputView()
    private lateinit var logicManager: LogicManager

    fun start() {
        outputView.printStart()
        outputView.printGetCoach()
        val coachNames = inputView.getCoachNames()
        val unavailableFoods = mutableListOf<List<String>>()
        for (i in coachNames.indices) {
            outputView.printGetUnavailableFood(coachNames[i])
            unavailableFoods.add(inputView.getUnavailableFoods())
        }
        logicManager = LogicManager(coachNames, unavailableFoods)
        logicManager.pickCategory()
        logicManager.pickMenuFifth()

        outputView.printResult(logicManager.getCategoriesDetails(), logicManager.getCoachesDetails())
    }
}