package menu.view

object View {
    fun printStartComment() {
        UI.printStartMenuRecommend()
        println()
    }

    fun requestInputCoachName(): String {
        UI.printRequestInputCoachNames()
        return InputView.inputCoachNames()
    }

    fun requestInputCantEat(coachName : String) : List<String> {
        println()
        print(coachName)
        UI.printRequestInputCantEatMenu()
        return InputView.inputCantEat().split(",")
    }
}