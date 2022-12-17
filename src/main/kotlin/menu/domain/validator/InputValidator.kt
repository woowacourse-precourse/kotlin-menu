package menu.domain.validator

import menu.constants.MenuPhrases.BLANK_COACH_NAME_ERROR
import menu.constants.MenuPhrases.INCORRECT_COACH_NAME_SIZE_ERROR
import menu.constants.MenuPhrases.INCORRECT_COACH_NUMBER_ERROR
import menu.constants.MenuRule.MAX_COACH_NAME_SIZE
import menu.constants.MenuRule.MAX_COACH_NUMBER
import menu.constants.MenuRule.MIN_COACH_NAME_SIZE
import menu.constants.MenuRule.MIN_COACH_NUMBER

class InputValidator {
    fun getValidateCoachNames(userInput: String): List<String> {
        val processedUserInput = userInput.split(",")
        require(checkCoachNumber(processedUserInput)) { INCORRECT_COACH_NUMBER_ERROR }
        require(checkCoachNameSize(processedUserInput)) { INCORRECT_COACH_NAME_SIZE_ERROR }
        require(checkEmptyString(processedUserInput)) { BLANK_COACH_NAME_ERROR }
        return processedUserInput
    }

    private fun checkCoachNumber(input: List<String>): Boolean = input.size in MIN_COACH_NUMBER..MAX_COACH_NUMBER

    private fun checkCoachNameSize(coachNames: List<String>): Boolean {
        for (coachName in coachNames) if (coachName.length !in MIN_COACH_NAME_SIZE..MAX_COACH_NAME_SIZE) return false
        return true
    }

    private fun checkEmptyString(coachNames: List<String>): Boolean {
        for (coachName in coachNames) if (coachName.isBlank()) return false
        return true
    }
}
