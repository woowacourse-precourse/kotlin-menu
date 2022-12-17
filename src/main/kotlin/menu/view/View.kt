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
}