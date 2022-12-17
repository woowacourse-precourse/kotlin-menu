package menu

import camp.nextstep.edu.missionutils.Randoms

class LunchGame(
    private val recommendationMachine: RecommendationMachine = RecommendationMachine(),
    private val inputValidator: InputValidator = InputValidator(),
    private val view: View = View(),
) {

    private lateinit var coaches: List<Coach>

    fun play() {
        initCoaches()
        initHatingMenusToEachCoach()
        recommendMenus()
        showResult()
    }

    private fun showResult() {
        view.outputView.printResultRecommendation()
        view.outputView.printThisWeekCategories(recommendationMachine.thisWeekCategories.toList())
        coaches.forEach { eachCoach ->
            view.outputView.printCoachMenus(eachCoach)
        }
        view.outputView.printGameEnd()
    }

    private fun initCoaches() {
        coaches = getCoachesName().map { eachCoachName -> Coach(eachCoachName) }
    }

    private fun getCoachesName(): List<String> {
        while (true) {
            try {
                val coachesName = view.inputView.requestCoachesName()

                inputValidator.validateCoaches(coachesName)
                return coachesName.split(",")
            } catch (e: java.lang.IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun initHatingMenusToEachCoach() {
        coaches.forEach { eachCoach ->
            val hatingMenus = getHatingMenusName(eachCoach.name)
                .map { eachMenuName -> eachMenuName }

            eachCoach.setHatingMenus(hatingMenus)
        }
    }

    private fun getHatingMenusName(coachName: String): List<String> {
        while (true) {
            try {
                val hatingMenus = view.inputView.requestHatingMenus(coachName)

                inputValidator.validateHatingMenu(hatingMenus)
                return hatingMenus.split(",")
            } catch (e: java.lang.IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun recommendMenus() {
        recommendationMachine.initThisWeekCategories()

        coaches.forEach { eachCoach ->
            recommendationMachine.recommendMenu(eachCoach)
        }
    }
}