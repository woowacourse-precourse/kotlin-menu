package menu

class Controller {

    private val outputView = OutputView()
    private val inputView = InputView()

    fun run() {
        outputView.menuSuggestionStart()
        val coaches=inputView.coachNameInput()

    }
}