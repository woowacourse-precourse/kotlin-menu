package menu

import menu.view.View

class Menu {
    private val view = View()
    private val coaches = mutableListOf<Coach>()

    fun recommend() {
        val coachNames = view.getCoachName()
        for (name in coachNames) {
            coaches.add(Coach(name))
        }
        view.getCoachesBias(coaches)
        RandomMenu().getRecommendResult(coaches)
    }
}