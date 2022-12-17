package menu.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun getCoach(): String {
        println(MISSION_START)
        var input: String
        input = Console.readLine()
        return input
    }

    companion object {
        const val MISSION_START = "점심 메뉴 추천을 시작합니다."
    }
}