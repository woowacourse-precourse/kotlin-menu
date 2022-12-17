package menu.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun getCoach(): String {
        println(MISSION_START)
        println(GET_COACH_MESSAGE)
        var input: String
        input = Console.readLine()
        return input
    }

    fun getHateFood(coache: String): String {
        println(coache + COACH_HATE_FOOD_MESSAGE)
        var input: String
        input = Console.readLine()
        return input
    }


    companion object {
        const val MISSION_START = "점심 메뉴 추천을 시작합니다.\n"
        const val GET_COACH_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)"
        const val COACH_HATE_FOOD_MESSAGE = "(이)가 못 먹는 메뉴를 입력해 주세요."
    }
}