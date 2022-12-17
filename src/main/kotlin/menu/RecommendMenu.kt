package menu

import menu.controller.CategoryController
import menu.controller.MenuController
import menu.input.InputView
import menu.output.OutputView

class RecommendMenu {
    private val inputView = InputView()
    private val outputView = OutputView()

    private var coaches = listOf<String>()
    private val notEatMenus = mutableListOf<List<String>>()

    private val recommendCategories: List<String> = CategoryController().getRecommendCategory()
    private var recommendMenus = listOf<List<String>>()

    fun run() {
        startRecommend()
        inputCoachName()
        inputToNotEatMenu()

        recommendMenus = MenuController(coaches.toList(), recommendCategories.toList(), notEatMenus.toList()).getRecommendMenus()
        outputResult()
    }

    private fun startRecommend() {
        outputView.startRecommendMenu()
    }

    private fun inputCoachName() {
        outputView.inputCoachName()
        coaches = inputView.inputCoachName()
    }

    private fun inputToNotEatMenu() {
        coaches.forEach {
            outputView.inputNotEatMenu(it)
            notEatMenus.add(inputView.inputNotEatMenu(it))
        }
    }

    private fun outputResult() {
        outputView.resultRecommendMenu()
        outputView.outputHeaderDay()
        outputView.outputCategory(recommendCategories)
        outputView.outputRecommendMenu(coaches, recommendMenus)
        outputView.outputSuccessRecommend()
    }
}