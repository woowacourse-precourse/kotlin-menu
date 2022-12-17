package menu.controller

import menu.domain.*
import menu.view.InputView
import menu.view.OutputView

class MenuController() {

    private val inputView = InputView()
    private val outputView = OutputView()

    private val categories = Categories()
    private val recommender = MenuRecommender()

    fun run() {
        outputView.printStartMessage()

        val coaches = makeCoaches()
        setHateMenus(coaches)

        repeat(5) {
            var category = Category.makeRandomCategory()
            while (categories.add(category).not()) { category = Category.makeRandomCategory() }
            coaches.coaches.forEach {
                recommender.recommend(it, category)
            }
        }

        val result = coaches.coaches.associateWith { it.selectedMenus.toList() }
        outputView.printResult(MenuRecommender.Result(categories, result))
    }

    private fun makeCoaches(): Coaches {
        val names = inputView.readCoaches()
        val coaches = names.map { Coach(it) }
        return Coaches(coaches)
    }

    private fun setHateMenus(coaches: Coaches) {
        for (coach in coaches.coaches) {
            val menus = readHateMenus(coach)
            //todo
            readUntilValid { menus.forEach { coach.addHateMenu(it) } }
        }
    }

    private fun readHateMenus(coach: Coach): List<Menu> {
        return readUntilValid {
            inputView.readHateMenus(coach.name).map { Menu.from(it) }
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