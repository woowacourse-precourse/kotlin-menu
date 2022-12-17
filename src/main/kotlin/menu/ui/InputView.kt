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


    fun enterNoEating(): List<String> {
        while (true) {
            val noEating = Console.readLine() ?: ""
            kotlin.runCatching { checkNoEating(noEating) }
                .onSuccess { return noEating.split(",") }
                .onFailure { outputView.printErrorMessage(ERROR_RETRY) }
        }
    }

    private fun checkNoEating(noEating: String) {
        exceptNoEatingCount(noEating)

    }

    private fun checkCoachName(coachName: String) {
        exceptNameBlank(coachName)
        exceptCountCoach(coachName)
        exceptInputRule(coachName)
        exceptNameRule(coachName)
    }

    private fun exceptNoEatingCount(noEating: String) {
        val foodContainer = noEating.split(",")
        if (foodContainer.size > 2)
            throw IllegalArgumentException("${outputView.printErrorMessage(ERROR_NO_EATING_MAX)}")
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
        if (coachNameInput.length !in 4..14) {
            throw IllegalArgumentException("${outputView.printErrorMessage(ERROR_COACH_COUNT)}")
        }
    }

    private fun exceptInputRule(input: String) {
        if ((input.isNotEmpty()) and (!input.contains(",")))
            throw IllegalArgumentException("${outputView.printErrorMessage(ERROR_INPUT_RULE)}")
        if (input.contains(' '))
            throw IllegalArgumentException("${outputView.printErrorMessage(ERROR_INPUT_RULE_BLANK)}")
    }
}