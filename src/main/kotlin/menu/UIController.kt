package menu

class UIController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val validateService = ValidateService()

    fun start() {
        outputView.printStart()
    }

}