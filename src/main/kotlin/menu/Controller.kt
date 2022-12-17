package menu

class Controller(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val inputValidator: InputValidator
) {
    private val menu = Menu()
    private lateinit var coaches: List<String>
    private lateinit var lunchMenuRecommender: LunchMenuRecommender

    fun run() {
        outputView.printStartMessage()
        lunchMenuRecommender = initialize()
        startRecommendation(lunchMenuRecommender)
        outputView.printEndMessage()
    }

    private fun initialize(): LunchMenuRecommender {
        TODO()
    }

    private fun startRecommendation(lunchMenuRecommender: LunchMenuRecommender) {
        TODO()
    }

    private fun getCoachNames() {

    }

    private fun getDislikeMenus() {

    }
}