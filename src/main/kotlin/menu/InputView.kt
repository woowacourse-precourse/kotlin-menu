package menu

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun getCoachName(): List<String> {
        val input = Console.readLine()
        validateCoach(input)
        return input.split(",")
    }

    private fun validateCoach(input: String) {
        val pattern = Regex("(.+,?)+")
        if (!pattern.matches(input))
            throw IllegalArgumentException(Message.ERR_COACH_COMMA)
    }

    fun getDeclineMenu(): List<String> {
        val input = Console.readLine()
        validateDeclineMenu(input)
        return input.split(",")
    }

    private fun validateDeclineMenu(input: String) {
        val pattern = Regex("(.+,?)+")
        if (!pattern.matches(input))
            throw IllegalArgumentException(Message.ERR_DECLINE_MENU_COMMA)
    }
}