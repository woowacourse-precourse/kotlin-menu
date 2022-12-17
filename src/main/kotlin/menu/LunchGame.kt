package menu

import camp.nextstep.edu.missionutils.Randoms
import menu.FoodData.categories
import menu.OutputView.Companion.CATEGORY
import menu.OutputView.Companion.FINISHED
import menu.OutputView.Companion.MONDAY_TO_FRIDAY
import menu.OutputView.Companion.RESULT_OF_RECOMMENDATION
import menu.OutputView.Companion.START_RECOMMENDATION

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
        view.outputView.printMessage(START_RECOMMENDATION)
        view.outputView.printMessage(RESULT_OF_RECOMMENDATION)
        view.outputView.printMessage(MONDAY_TO_FRIDAY)
        view.outputView.printResults(CATEGORY, recommendationMachine.thisWeekCategories.toList().map { categoryNum ->
            categories[categoryNum]!!
        })
        coaches.forEach { eachCoach ->
            view.outputView.printResults(eachCoach.name, eachCoach.thisWeekMenus)
        }
        view.outputView.printMessage(FINISHED)
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
        repeat(5){
            recommendationMachine.selectTodayCategory()
            recommendationMachine.recommendTodayMenu(coaches)
        }
    }
}