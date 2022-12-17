package menu

import menu.view.View

class Menu {
    private val view = View()

    fun recommend() {
        view.getCoachName()
    }
}