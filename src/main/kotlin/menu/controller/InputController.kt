package menu.controller

import menu.domain.Coach
import menu.domain.CoachName
import menu.domain.Menus
import menu.view.InputView

class InputController {
    fun getCoach(): Coach {
        try {
            return InputView.readCoaches()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return getCoach()
        }
    }

    fun getMenus(coach: CoachName): Menus {
        try {
            return InputView.readMenus(coach)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return getMenus(coach)
        }
    }
}