package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.domain.Validator

class InputView(
    private val validator: Validator
) {

    fun readRecommendCoaches(): List<String> {
        val input = Console.readLine()

        return input.split(",").toList()
    }

    fun readCoachCantEatMenus(): List<String> {
        val input = Console.readLine()

        return input.split(",").toList()
    }
}