package menu.controller

import menu.domain.Generator
import menu.model.Coach
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
        setCoachRecommendations(coaches)

        printRecommendations(coaches)
        noticeEnd()
    }

    private fun printRecommendations(coaches: List<Coach>) {
        outputView.printMessage(NOTICE_SERVICE_END_MESSAGE)


    }

    private fun setCoachRecommendations(coaches: List<Coach>) {
        repeat(coaches.size) { coachIndex ->
            // todo 상수화
            repeat(5) { dayWeeksIndex ->
                val recommendation = generator.makeRecommendation(coaches[coachIndex])
                coaches[coachIndex].addRecommendation(recommendation)
            }
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
