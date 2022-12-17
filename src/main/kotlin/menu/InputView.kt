package menu

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun requestCoachesName(): String {
        println("코치의 이름을 입력해 주세요. (, 로 구분)")

        return Console.readLine()
    }

    fun requestHatingMenus(coachName:String): String {
        println("%s(이)가 못 먹는 메뉴를 입력해 주세요.".format(coachName))

        return Console.readLine()
    }
}