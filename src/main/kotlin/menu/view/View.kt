package menu.view

class View {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun getCoachName(): List<String> {
        outputView.printStartMessage()
        outputView.requestCoachNames()
        return try {
            inputView.getCoachNames()
        } catch (e: IllegalArgumentException) {
            println(e)
            getCoachName()
        }
    }
}