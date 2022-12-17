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
        coaches = getCoachNames()
        val coachDislikeMenus = mutableMapOf<String, List<String>>()
        coaches.forEach {
            coachDislikeMenus[it] = getDislikeMenus(it)
        }
        return LunchMenuRecommender(coachDislikeMenus, menu.menus(), coaches)
    }

    private fun startRecommendation(lunchMenuRecommender: LunchMenuRecommender) {
        val recommendation = lunchMenuRecommender.chooseOneWeekMenu()
        outputView.printMenuRecommendation(recommendation, coaches)
    }

    private fun getCoachNames(): List<String> {
        while (true) {
            try {
                val coachNamesInput = inputView.readCoachNames()
                return inputValidator.validateCoachNames(coachNamesInput)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun getDislikeMenus(name: String): List<String> {
        while (true) {
            try {
                val dislikeMenusInput = inputView.readDislikeMenus(name)
                return inputValidator.validateDislikeMenus(dislikeMenusInput, menu)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}