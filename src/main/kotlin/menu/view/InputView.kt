package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.domain.Validator

class InputView(
    private val validator: Validator
) {

    fun readRecommendCoaches(): List<String> {
        val input = Console.readLine()
        validator.validateRecommendCoaches(input)
        return input.split(",").toList()
    }

    fun readCoachCantEatMenus(): List<String> {
        val input = Console.readLine()
        validator.validateCoachCantEatMenus(input)
        return input.split(",").toList()
    }
}