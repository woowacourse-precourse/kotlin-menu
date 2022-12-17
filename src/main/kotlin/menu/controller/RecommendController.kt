package menu.controller

import menu.input.InputView
import menu.output.OutputView

class RecommendController {
    private val inputView = InputView()
    private val outputView = OutputView()

    private val coaches: List<String>
    private val notEatMenus = mutableListOf<List<String>>()

    private val recommendCategories: List<String> = CategoryController().getRecommendCategory()
    private val recommendMenus: List<List<String>>

    init {
        outputView.startRecommendMenu()

        outputView.inputCoachName()
        coaches = inputView.inputCoachName()

        notEatMenu()

        recommendMenus = MenuController(coaches, recommendCategories, notEatMenus).getRecommendMenus()

        outputView.resultRecommendMenu()
        outputView.outputHeaderDay()
        outputView.outputCategory(recommendCategories)
        outputView.outputRecommendMenu(coaches, recommendMenus)
        outputView.outputSuccessRecommend()
    }

    private fun notEatMenu() {
        coaches.forEach {
            outputView.inputNotEatMenu(it)
            notEatMenus.add(inputView.inputNotEatMenu(it))
        }
    }
}