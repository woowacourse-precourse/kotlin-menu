package menu.controller

import menu.values.REQUIRE_COACHES_MESSAGE
import menu.values.REQUIRE_COACH_CANT_EAT_MENUS_MESSAGE
import menu.view.InputView
import menu.view.OutputView

class ServiceController(
    private val inputView: InputView,
    private val outputView: OutputView
) {

    fun run() {
        val coches = getValidatedInputCoaches()
    }

    private fun getValidatedInputCoaches(): List<String> {
        while (true) {
            try {
                outputView.printMessage(REQUIRE_COACHES_MESSAGE)
                return inputView.readRecommendCoaches()
            } catch (e: IllegalArgumentException) {
                outputView.printErrorMessage(e)
            }
        }
    }

    private fun getValidatedCoachCantEatMenus(): List<String> {
        while (true) {
            try {
                outputView.printMessage(REQUIRE_COACH_CANT_EAT_MENUS_MESSAGE)
                return inputView.readCoachCantEatMenus()
            } catch (e: IllegalArgumentException) {
                outputView.printErrorMessage(e)
            }
        }
    }

}
