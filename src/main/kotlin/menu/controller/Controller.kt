package menu.controller

import menu.common.Category
import menu.domain.CategoryCreator
import menu.domain.Coach
import menu.view.InputView
import menu.view.OutputView

class Controller(
    private val outputView: OutputView,
    private val inputView: InputView
) {
    private val coaches = mutableSetOf<Coach>()

    fun start() {
        outputView.showStart()
    }

    fun inputNames() {
        try {
            outputView.requestInputName()
            createCoaches(inputView.readCoachesName())
        } catch (e: IllegalArgumentException) {
            outputView.showErrorMessage(e.message ?: "")
            inputNames()
        }
    }

    private fun createCoaches(names: List<String>) {
        names.forEach {
            coaches.add(Coach(it))
        }
    }

    fun inputInedibleMenus() {
        coaches.forEach {
            inputInedibleMenu(it)
        }
    }

    private fun inputInedibleMenu(coach: Coach) {
        try {
            outputView.requestInputInedibleFood(coach.coachName)
            coach.decideInedibleMenus(inputView.readInedibleMenus())
        } catch (e: IllegalArgumentException) {
            outputView.showErrorMessage(e.message ?: "")
            inputInedibleMenu(coach)
        }
    }

    fun suggestMenus() {
        val categories = CategoryCreator().createCategories()
        categories.forEach {
            suggestMenu(it)
        }
        outputView.showResult(categories, coaches)
    }

    private fun suggestMenu(category: Category) {
        coaches.forEach {
            it.suggestMenu(category)
        }
    }
}
