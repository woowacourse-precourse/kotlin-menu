package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.domain.Coach
import menu.utils.Validator.checkCoachesValid

class InputView {
    fun getCoaches(): List<Coach> {
        val input = Console.readLine()
        checkCoachesValid(input)
        return input.split(',').map { Coach(it) }
    }
}