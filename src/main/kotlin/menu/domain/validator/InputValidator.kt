package menu.domain.validator

import menu.constants.MenuPhrases.BLANK_COACH_NAME_ERROR
import menu.constants.MenuPhrases.COACH_MENU_BAN_NOT_IN_EXIST_MENU
import menu.constants.MenuPhrases.COACH_MENU_BAN_SIZE_ERROR
import menu.constants.MenuPhrases.INCORRECT_COACH_NAME_SIZE_ERROR
import menu.constants.MenuPhrases.INCORRECT_COACH_NUMBER_ERROR
import menu.constants.MenuRule.MAX_COACH_MENU_BAN_SIZE
import menu.constants.MenuRule.MAX_COACH_NAME_SIZE
import menu.constants.MenuRule.MAX_COACH_NUMBER
import menu.constants.MenuRule.MIN_COACH_MENU_BAN_SIZE
import menu.constants.MenuRule.MIN_COACH_NAME_SIZE
import menu.constants.MenuRule.MIN_COACH_NUMBER
import menu.domain.AvaliableMenu

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

    fun getCoachWithMenuBan(userInput: String, coachName: String): List<String> {
        val coachWithMenuBan = mutableListOf(coachName)
        val processedUserInput = userInput.split(",")
        if (processedUserInput[0].isBlank()) return coachWithMenuBan
        require(checkCoachMenuBanSize(processedUserInput)) { COACH_MENU_BAN_SIZE_ERROR }
        require(checkMenuBanInExistMenu(processedUserInput)) { COACH_MENU_BAN_NOT_IN_EXIST_MENU }
        coachWithMenuBan.addAll(processedUserInput)
        return coachWithMenuBan
    }

    private fun checkCoachMenuBanSize(banMenus: List<String>): Boolean =
        banMenus.size in MIN_COACH_MENU_BAN_SIZE..MAX_COACH_MENU_BAN_SIZE

    private fun checkMenuBanInExistMenu(banMenus: List<String>): Boolean {
        var inExistMenu = false
        AvaliableMenu.values().forEach { for (banMenu in banMenus) if (banMenu in it.menus) inExistMenu = true }
        return inExistMenu
    }
}
