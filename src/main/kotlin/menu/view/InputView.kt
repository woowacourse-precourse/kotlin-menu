package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.util.Exceptions
import menu.util.INPUT_COACH_NAME
import menu.util.INPUT_COACH_NOT_EAT
import java.lang.IllegalArgumentException


class InputView {

    // 코치들의 이름을 입력 받는다.
    fun readCoachName(): List<String> {
        println(INPUT_COACH_NAME)
        return try {
            val coaches = Console.readLine().split(',')
            Exceptions.checkCoachesInput(coaches)
            println()
            return coaches
        } catch (e: IllegalArgumentException) {
            println(e.message)
            readCoachName()
        }
    }

    // 코치의 못먹는 메뉴를 입력 받는다.
    fun readCoachNotEat(coach: String): List<String> {
        println(coach + INPUT_COACH_NOT_EAT)
        return try {
            val menus = Console.readLine().split(',')
            println(menus)
            Exceptions.checkCoachNotToEatInput(menus)
            println()
            return menus
        } catch (e: IllegalArgumentException) {
            println(e.message)
            readCoachNotEat(coach)
        }
    }
}