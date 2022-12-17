package menu.controller

import menu.domain.Generator
import menu.model.Coach
import menu.model.Recommendation
import menu.values.NOTICE_RECOMMEND_SUCCESS_MESSAGE
import menu.values.NOTICE_SERVICE_END_MESSAGE
import menu.values.NOTICE_SERVICE_START_MESSAGE
import menu.values.REQUIRE_COACHES_MESSAGE
import menu.view.InputView
import menu.view.OutputView

class ServiceController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val generator: Generator
) {

    fun run() {
        noticeStart()
        
        val coaches: List<Coach> = getCoaches()
        val recommendations: List<Recommendation> = createRecommendations(coaches)

        printResultRecommendation(recommendations)
        noticeEnd()
    }

    private fun createRecommendations(coaches: List<Coach>): List<Recommendation> {
        val days = listOf("월요일", "화요일", "수요일", "목요일", "금요일")

        return generator.makeRecommendations(days, coaches)
    }

    private fun printResultRecommendation(recommendations: List<Recommendation>) {
        outputView.printMessage(NOTICE_SERVICE_END_MESSAGE)
        outputView.printList(listOf("구분", "월요일", "화요일", "수요일", "목요일", "금요일"))
        val categories = mutableListOf<String>()
        repeat(recommendations.size) { categories.add(recommendations[it].category) }
        outputView.printList(listOf("카테고리") + categories)

        val coachesMenus = MutableList<MutableList<String>> (recommendations.size) { mutableListOf() }

        repeat(recommendations.size) { index1 ->
            repeat(recommendations[index1].coachesMenus.size) { index2 ->
                coachesMenus[index2].add(recommendations[index2].coachesMenus[index2].first)
            }
            repeat(recommendations[index1].coachesMenus.size) { index2 ->
                coachesMenus[index2].add(recommendations[index1].coachesMenus[index2].second)
            }
        }

        repeat(recommendations[0].coachesMenus.size) {
            outputView.printList(coachesMenus[it].distinct())
        }
    }


    private fun noticeStart() {
        outputView.printMessage(NOTICE_SERVICE_START_MESSAGE)
        println()
    }

    private fun noticeEnd() {
        outputView.printMessage(NOTICE_RECOMMEND_SUCCESS_MESSAGE)
    }

    private fun getCoaches(): List<Coach> {
        val coaches = mutableListOf<Coach>()
        val coachNames = getValidatedInputCoaches()

        repeat (coachNames.size) { index ->
            val coachName = coachNames[index]
            val coachCantEatMenus = getValidatedCoachCantEatMenus(coachName)
            coaches.add(Coach(coachName, coachCantEatMenus))
        }

        return coaches
    }

    private fun getValidatedInputCoaches(): List<String> {
        while (true) {
            try {
                outputView.printMessage(REQUIRE_COACHES_MESSAGE)
                return inputView.readRecommendCoaches()
                // todo 줄바꾸기
            } catch (e: IllegalArgumentException) {
                outputView.printErrorMessage(e)
            }
        }
    }

    private fun getValidatedCoachCantEatMenus(coachName: String): List<String> {
        while (true) {
            try {
                outputView.printRequireCoachCantEatMenus(coachName)
                return inputView.readCoachCantEatMenus()
                // todo 줄바꾸기
            } catch (e: IllegalArgumentException) {
                outputView.printErrorMessage(e)
            }
        }
    }

}
