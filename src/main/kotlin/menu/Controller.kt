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
        val coachNamesInput = inputView.readCoachNames()
        coaches = inputValidator.validateCoachNames(coachNamesInput)
        val coachDislikeMenus = mutableMapOf<String, List<String>>()
        coaches.forEach {
            val dislikeMenusInput = inputView.readDislikeMenus(it)
            val dislikeMenu = inputValidator.validateDislikeMenus(dislikeMenusInput, menu)
            coachDislikeMenus[it] = dislikeMenu
        }
        return LunchMenuRecommender(coachDislikeMenus, menu.menus(), coaches)
    }

    private fun startRecommendation(lunchMenuRecommender: LunchMenuRecommender) {
        val recommendation = lunchMenuRecommender.chooseOneWeekMenu()
        outputView.printMenuRecommendation(recommendation, coaches)
    }

    private fun getCoachNames() {

    }

    private fun getDislikeMenus() {

    }
}