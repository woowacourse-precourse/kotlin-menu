package menu.controller

import menu.WEEK_NUMBER
import menu.domain.Coach
import menu.domain.Coaches
import menu.domain.Menu
import menu.domain.MenuRecommender
import menu.view.InputView
import menu.view.OutputView

class MenuController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        outputView.printStartMessage()

        val coaches = readUntilValid { makeCoaches() }
        for (coach in coaches.coaches) {
            setHateMenus(coach)
        }

        val recommender = MenuRecommender(coaches)
        val result = recommender.recommendAll(WEEK_NUMBER)
        outputView.printResult(result)
    }

    private fun makeCoaches(): Coaches {
        val names = inputView.readCoachNames()
        val coaches = names.map { Coach(it) }
        return Coaches(coaches)
    }

    private fun setHateMenus(coach: Coach) {
        val menus = readHateMenus(coach)
        readUntilValid {
            menus.forEach { coach.addHateMenu(it) }
        }
    }

    private fun readHateMenus(coach: Coach): List<Menu> {
        return readUntilValid {
            inputView.readHateMenus(coach.name)
                .map { Menu.from(it) }
        }
    }

    private fun <T> readUntilValid(method: () -> T): T {
        return try {
            method()
        } catch (e: IllegalArgumentException) {
            outputView.printException(e)
            readUntilValid { method() }
        }
    }
}
