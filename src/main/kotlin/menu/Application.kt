package menu

fun main() {
    val outputView = OutputView()
    val inputView = InputView()
    outputView.printServiceStart()
    val coaches = inputView.inputCoaches()
    val coachesNotEatFoods = inputView.inputCoachNotEat(coaches)
    println("-------")
    println(coachesNotEatFoods)

}
