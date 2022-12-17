package menu.controller

import menu.domain.CategoryGenerator
import menu.model.Coach
import menu.model.Coaches
import menu.view.OutputView
import menu.values.MenuMessage
import menu.view.InputView

class MenuController {
    private val outputView = OutputView()
    private val inputView = InputView(outputView)
    private val coaches = Coaches()

    fun run() {
        val categoriesGenerator = CategoryGenerator()
        val weekCategories = categoriesGenerator.generate()
        outputView.printMessage(MenuMessage.START_MENU_RECOMMEND)

        addCoaches()
        coaches.recommendCoachesMenu(weekCategories)
        outputView.printMenu(weekCategories, coaches.coaches)
    }

    private fun addCoaches() {
        val coachesName = requestCoachName()
        repeat(coachesName.size) { name ->
            val hateMenu = requestHateMenu(coachesName[name])
            val coach = Coach(coachesName[name], hateMenu)
            coaches.addCoach(coach)
        }
    }

    private fun requestCoachName(): List<String> {
        while (true) {
            try {
                return inputView.readCoach()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun requestHateMenu(name: String): List<String> {
        while (true) {
            try {
                return inputView.readHateMenu(name)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}