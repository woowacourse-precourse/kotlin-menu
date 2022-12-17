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
        val splitInput = input.split(",")
        if (splitInput.size < 2)
            throw IllegalArgumentException(Message.ERR_COACH_MORE_THAN_TWO)
        else if (splitInput.size > 5)
            throw IllegalArgumentException(Message.ERR_COACH_LESS_THAN_FIVE)
        for (i in splitInput) {
            if (i.length < 2)
                throw IllegalArgumentException(Message.ERR_COACH_NAME_MORE_THAN_TWO)
            else if (i.length > 4)
                throw IllegalArgumentException(Message.ERR_COACH_NAME_LESS_THAN_FOUR)
        }
    }

    fun getDeclineMenu(): List<String> {
        val input = Console.readLine()
        validateDeclineMenu(input)
        return input.split(",")
    }

    private fun validateDeclineMenu(input: String) {
        val pattern = Regex("(.+,?)*")
        if (!pattern.matches(input))
            throw IllegalArgumentException(Message.ERR_DECLINE_MENU_COMMA)
        val splitInput = input.split(",")
        if (splitInput.size > 2)
            throw IllegalArgumentException(Message.ERR_DECLINE_MENU_LESS_THAN_TWO)

    }
}