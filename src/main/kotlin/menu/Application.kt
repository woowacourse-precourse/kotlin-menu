package menu

fun main() {
    val outputView = OutputView()
    val inputView = InputView()
    outputView.printServiceStart()
    val coaches = inputView.inputCoaches()
    val coachesNotEatFoods = inputView.inputCoachNotEat(coaches)
    val recommendMenu = RecommendMenu(coachesNotEatFoods)
    outputView.printBlankLine()
    val result = recommendMenu.processRecommendMenu()
    outputView.printResult(recommendResult = result)
}


