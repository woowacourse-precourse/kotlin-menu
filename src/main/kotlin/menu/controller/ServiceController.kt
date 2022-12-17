package menu.controller

import menu.model.Coach
import menu.values.NOTICE_SERVICE_START_MESSAGE
import menu.values.REQUIRE_COACHES_MESSAGE
import menu.view.InputView
import menu.view.OutputView

class ServiceController(
    private val inputView: InputView,
    private val outputView: OutputView
) {

    fun run() {

        val coaches: List<Coach> = getCoaches()
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
