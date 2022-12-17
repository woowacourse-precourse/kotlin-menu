package menu

import menu.controller.RecommendController
import menu.domain.CategoryMaker
import menu.domain.CoachGenerator
import menu.domain.RandomCategoryNumberGenerator
import menu.domain.RandomMenuGenerator
import menu.view.InputView
import menu.view.OutputView

fun main() {
    val categoryNumberGenerator = RandomCategoryNumberGenerator()
    val categoryMaker = CategoryMaker(categoryNumberGenerator)

    val menuGenerator = RandomMenuGenerator()
    val coachGenerator = CoachGenerator(menuGenerator)

    val inputView = InputView()
    val outputView = OutputView()

    val controller = RecommendController(categoryMaker, coachGenerator, inputView, outputView)
    controller.startService()
}
