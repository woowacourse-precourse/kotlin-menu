package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.domain.Coach
import menu.utils.INPUT_COACH_NAME
import menu.utils.MENU_RECOMMEND

object InputView {
    fun readCoaches(): Coach {
        println(MENU_RECOMMEND)
        println(INPUT_COACH_NAME)
        return Coach(Console.readLine().split(","))
    }
}