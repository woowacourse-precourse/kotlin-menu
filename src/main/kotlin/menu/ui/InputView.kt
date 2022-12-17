package menu.ui

import camp.nextstep.edu.missionutils.Console

class InputView {

    /**
     * 코치의 이름을 입력받는다.
     */
    fun readCoachName(): String {
        println(ENTER_COACH_NAME)
        return inputValue()
    }

    /**
     * 코치가 먹지 못하는 음식을 입력받는다.
     */
    fun readInedibleFoodName(coachName: String): String {
        println(ENTER_INEDIBLE_FOOD.format(coachName))
        return inputValue()
    }

    private fun inputValue(): String = Console.readLine()

    companion object {
        const val ENTER_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)"
        const val ENTER_INEDIBLE_FOOD = "%s(이)가 못 먹는 메뉴를 입력해 주세요."
    }
}