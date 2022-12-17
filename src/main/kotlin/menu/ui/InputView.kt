package menu.ui

import camp.nextstep.edu.missionutils.Console
import menu.data.ERROR_COACH_NAME
import menu.data.ERROR_INPUT_EMPTY
import menu.data.ERROR_RETRY

class InputView {
    private val outputView = OutputView()

    fun enterCoachName(): String {
        while (true) {
            val coachName = Console.readLine()
            kotlin.runCatching { checkCoachName(coachName) }
                .onSuccess { return coachName }
                .onFailure { outputView.printErrorMessage(ERROR_RETRY) }
        }
    }


    fun enterNoEating() {
        val noEating = Console.readLine()
    }

    private fun checkCoachName(coachName: String) {
        if (coachName.length !in 2..4) {
            throw IllegalArgumentException("${outputView.printErrorMessage(ERROR_COACH_NAME)}")
        }

        if (coachName.isBlank()) throw IllegalArgumentException("${outputView.printErrorMessage(ERROR_INPUT_EMPTY)}")
    }
}