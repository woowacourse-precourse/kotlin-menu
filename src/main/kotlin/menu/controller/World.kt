package menu.controller

import menu.data.Message
import menu.data.Category
import menu.data.Coach
import menu.data.Menu
import menu.model.MenuRecommender
import menu.view.InputView
import menu.view.OutputView

class World {
    private val outputView = OutputView()
    private val inputView = InputView()

    private val coaches = mutableListOf<Coach>()

    init {
        outputView.print(Message.MSG_START)

        processCoach()
        processRecommendation(coaches)
    }

    private fun processCoach() {
        val names = processCoachName()
        for (name in names) {
            val menus = processDeclineMenus(name)
            coaches.add(Coach(name, menus))
        }
    }

    private fun processCoachName(): List<String> {
        outputView.print(Message.MSG_COACH_NAME)

        return inputView.getCoachName()
    }

    private fun processDeclineMenus(name: String): List<Menu> {
        outputView.print(Message.MSG_DECLINE_MENU, Pair("NAME", name))

        return inputView.getDeclineMenu().map { Menu(it) }
    }

    private fun processRecommendation(coaches: List<Coach>) {
        val menuRecommender = MenuRecommender()
        val categories = menuRecommender.generateWeekCategory()
        val recommendedMenus = menuRecommender.getRecommendation(categories, coaches)

        outputView.printRecommendationResult(categories, recommendedMenus)
    }

}