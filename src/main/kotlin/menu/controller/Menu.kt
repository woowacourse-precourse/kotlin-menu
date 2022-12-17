package menu.controller

import menu.data.Coach
import menu.domain.RandomMenu
import menu.view.View

class Menu {
    private val view = View()
    private val coaches = mutableListOf<Coach>()

    fun recommend() {
        view.printStartMessage()
        val coachNames = view.getCoachName()
        for (name in coachNames) {
            coaches.add(Coach(name))
        }
        view.getCoachesBias(coaches)
        val categories = RandomMenu().getRecommendMenus(coaches)
        view.printResultRecommend(coaches, categories)
    }
}