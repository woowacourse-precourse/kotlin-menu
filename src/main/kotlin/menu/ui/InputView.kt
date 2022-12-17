package menu.ui

import camp.nextstep.edu.missionutils.Console
import menu.data.*

class InputView {
    private val outputView = OutputView()

    fun enterCoachName(): List<String> {
        while (true) {
            val coachName = Console.readLine()
            kotlin.runCatching { checkCoachName(coachName) }
                .onSuccess { return coachName.split(",") }
                .onFailure { outputView.printErrorMessage(ERROR_RETRY) }
        }
    }


    fun enterNoEating() {
        val noEating = Console.readLine()
    }

    private fun checkCoachName(coachName: String) {
        exceptInputRule(coachName)
        exceptCountCoach(coachName)
        exceptNameBlank(coachName)
        exceptNameRule(coachName)
    }

    private fun exceptNameRule(coachNameInput: String) {
        val coachContainer = coachNameInput.split(",")
        for (coachName in coachContainer.indices) {
            if (coachContainer[coachName].length !in 2..4) {
                throw IllegalArgumentException("${outputView.printErrorMessage(ERROR_COACH_NAME)}")
            }
        }
    }

    private fun exceptNameBlank(coachNameInput: String) {
        if (coachNameInput.isBlank())
            throw IllegalArgumentException("${outputView.printErrorMessage(ERROR_INPUT_EMPTY)}")
    }

    private fun exceptCountCoach(coachNameInput: String) {
        if (coachNameInput.length !in 5..14) {
            throw IllegalArgumentException("${outputView.printErrorMessage(ERROR_COACH_COUNT)}")
        }
    }

    private fun exceptInputRule(coachNameInput: String) {
        if (!coachNameInput.contains(","))
            throw IllegalArgumentException("${outputView.printErrorMessage(ERROR_INPUT_RULE)}")
        if (coachNameInput.contains(' '))
            throw IllegalArgumentException("${outputView.printErrorMessage(ERROR_INPUT_RULE_BLANK)}")
    }
}