package menu.controller

import menu.data.Message
import menu.model.Category
import menu.model.Coach
import menu.model.Menu
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
        val recommendedMenus = getRecommendation(menuRecommender, categories, coaches)

        outputView.printRecommendationResult(categories, recommendedMenus)
    }

    private fun getRecommendation(
        menuRecommender: MenuRecommender,
        categories: List<Category>,
        coaches: List<Coach>
    ): Map<Coach, List<Menu>> {
        val menusByCoaches = mutableMapOf<Coach, MutableList<Menu>>()
        for (i in 0..4) {
            getDayRecommendation(menusByCoaches, menuRecommender, categories, coaches, i)
        }
        return menusByCoaches
    }

    private fun getDayRecommendation(
        menusByCoaches: MutableMap<Coach, MutableList<Menu>>,
        menuRecommender: MenuRecommender,
        categories: List<Category>,
        coaches: List<Coach>, dayOfWeek: Int
    ) {
        for (coach in coaches) {
            getCoachRecommendation(menusByCoaches, menuRecommender, categories, dayOfWeek, coach)
        }
    }

    private fun getCoachRecommendation(
        menusByCoaches: MutableMap<Coach, MutableList<Menu>>,
        menuRecommender: MenuRecommender,
        categories: List<Category>, dayOfWeek: Int, coach: Coach
    ) {
        if (menusByCoaches[coach] == null)
            menusByCoaches[coach] = mutableListOf()
        val menu = menuRecommender.generateMenuByCoach(coach, menusByCoaches[coach]!!, categories, dayOfWeek)
        menusByCoaches[coach]?.add(menu)
    }
}