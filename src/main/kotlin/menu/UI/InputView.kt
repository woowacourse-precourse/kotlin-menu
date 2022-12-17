package menu.UI

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun coachName() : List<String>{
        println("코치의 이름을 입력해 주세요. (, 로 구분)")
        var coachNames = Console.readLine().split(",")
        return coachNames
    }
}