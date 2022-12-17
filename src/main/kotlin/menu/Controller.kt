package menu

class Controller {
    private val outputView = OutputView()
    private val inputView = InputView()
    private val suggestion = SuggestionMenu()

    fun run() {
        outputView.menuSuggestionStart()
        val coaches = inputView.coachNameInput()
        inputView.coachHateMenuInput(coaches,suggestion.getAllMenus())
        val category = suggestion.suggestionMenus(coaches)
        outputView.menuSuggestionResult(coaches, category)
    }
}