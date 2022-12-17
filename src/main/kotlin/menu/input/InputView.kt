package menu.input

import menu.exception.CoachNameException
import menu.exception.NotEatMenuException
import camp.nextstep.edu.missionutils.Console

class InputView {
    // TODO: 코치 이름 입력 받기, 해당 코치가 못 먹는 메뉴 입력 받기

    fun inputCoachName(): List<String> {
        val coaches = Console.readLine()!!.replace(" ", "")

        CoachNameException(coaches)

        return coaches.split(',')
    }

    fun inputNotEatMenu(): List<String> {
        val menus = Console.readLine()!!

        NotEatMenuException(menus)

        return menus.split(',')
    }
}