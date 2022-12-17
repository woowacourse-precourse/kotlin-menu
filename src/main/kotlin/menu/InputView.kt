package menu

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun getCoachName() :List<String> {
        println("코치의 이름을 입력해 주세요. (, 로 구분)")
        return Console.readLine().split(",")
    }

    fun getHateMenu(name: String) :List<String> {
        println("\n${name}(이)가 못 먹는 메뉴를 입력해 주세요.")
        return Console.readLine().split(",")
    }
}

