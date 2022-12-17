package menu.input

import menu.exception.CoachNameException

class InputView {
    // TODO: 코치 이름 입력 받기, 해당 코치가 못 먹는 메뉴 입력 받기

    fun inputCoachName(): List<String> {
        val coaches = readLine()!!

        CoachNameException(coaches)

        return coaches.split(',')
    }
}