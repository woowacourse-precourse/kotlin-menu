package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.domain.Coach
import menu.domain.CoachName
import menu.domain.Menus
import menu.utils.INPUT_COACH_NAME
import menu.utils.INPUT_MENUS
import menu.utils.MENU_RECOMMEND

object InputView {
    fun readCoaches(): Coach {
        println(MENU_RECOMMEND)
        println(INPUT_COACH_NAME)
        return Coach(Console.readLine().split(","))
    }

    fun readMenus(coachName: CoachName): Menus {
        println(INPUT_MENUS.format(coachName.getName()))
        return Menus(Console.readLine().split(","))
    }
}