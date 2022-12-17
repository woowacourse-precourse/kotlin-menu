package menu.controller

import menu.service.MenuService
import menu.view.InputView
import menu.view.OutputView

class MenuController(
    inputView: InputView,
    outputView: OutputView,
    private val menuService: MenuService
) : Controller(inputView, outputView) {
    override fun run() {
        printStartMessage()
        val coachesNames = inputCoaches()
        val inEdibleFoodsAboutCoaches = inputInedibleFoods(coachesNames)
        recommendMenu(inEdibleFoodsAboutCoaches)
    }

    private fun printStartMessage() {
        outputView.printStartMessage()
    }

    private fun inputCoaches(): List<String> = repeat(inputView::inputCoaches)

    private fun inputInedibleFoods(coachesNames: List<String>): Map<String, List<String>> {
        val inedibleFoodsPerCoach = hashMapOf<String, List<String>>()
        coachesNames.forEach { coachName ->
            inedibleFoodsPerCoach[coachName] = inputInedibleFoodsPerCoach(coachName)
        }
        return inedibleFoodsPerCoach
    }

    private fun inputInedibleFoodsPerCoach(coachName: String): List<String> {
        outputView.printInedibleFoodInputMessage(coachName)
        return repeat(inputView::inputInedibleFoods)
    }

    private fun recommendMenu(inEdibleFoodsAboutCoaches: Map<String, List<String>>) {
        println(menuService.recommendMenuByDaysOfWeek(inEdibleFoodsAboutCoaches))
    }
}