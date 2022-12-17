package menu.input

import menu.exception.CoachNameException
import menu.exception.NotEatMenuException
import camp.nextstep.edu.missionutils.Console
import menu.data.InputType
import menu.output.OutputView

class InputView {
    // TODO: 코치 이름 입력 받기, 해당 코치가 못 먹는 메뉴 입력 받기

    fun inputCoachName(): List<String> {
        while(true) {
            try {
                val coaches = Console.readLine()!!.replace(" ", "")
                CoachNameException(coaches)
                return coaches.split(',')
            } catch (e: IllegalArgumentException) {
                OutputView().outputException(InputType.COACH_NAME, e.message!!)
            }
        }
    }

    fun inputNotEatMenu(coachName: String): List<String> {
        while(true) {
            try {
                val menus = Console.readLine()!!
                NotEatMenuException(menus)
                return menus.split(',')
            } catch (e: IllegalArgumentException) {
                OutputView().outputException(InputType.MENU, e.message!!, coachName)
            }
        }
    }
}