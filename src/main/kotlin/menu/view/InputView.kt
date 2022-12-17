package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.domain.Coach
import menu.utils.Validator.checkCoachesValid
import menu.utils.Validator.checkHateMenusSize

class InputView {
    fun getCoaches(): List<Coach> {
        OutputView().printInputCoachNameMessage()
        val input = Console.readLine()
        checkCoachesValid(input)
        return input.split(',').map { Coach(it, getHateMenus(it)) }
    }

    private fun getHateMenus(coachName: String): List<String> {
        OutputView().printInputCoachHateMenusMessage(coachName)
        val input = Console.readLine()
        checkHateMenusSize(input)
        return input.split(',')
    }
}