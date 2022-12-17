package menu

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readCoachNames(): String {
        println(READ_COACH_NAME_PROMPT)
        return Console.readLine()
    }

    fun readDislikeMenus(name: String): String {
        println(READ_DISLIKE_MENU_PROMPT.format(name))
        return Console.readLine()
    }

    companion object {
        private const val READ_COACH_NAME_PROMPT = "코치의 이름을 입력해 주세요. (, 로 구분)"
        private const val READ_DISLIKE_MENU_PROMPT = "%s(이)가 못 먹는 메뉴를 입력해 주세요."
    }
}