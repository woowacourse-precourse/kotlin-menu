package menu

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readCoachNames(): String {
        println("코치의 이름을 입력해 주세요. (, 로 구분)")
        return Console.readLine()
    }

    fun readDislikeMenus(name: String): String {
        println("${name}(이)가 못 먹는 메뉴를 입력해 주세요.")
        return Console.readLine()
    }
}