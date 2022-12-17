package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.domain.model.Coach

class InputView {

    fun startMenuRecommand() {
        println("점심 메뉴 추천을 시작합니다.\n")
    }

    fun coachName(): String {
        println("코치의 이름을 입력해 주세요. (, 로 구분)")
        return Console.readLine()
    }

    fun inedibleFood(coach: Coach): String {
        println("${coach.getName()}(이)가 못 먹는 메뉴를 입력해 주세요.")
        return Console.readLine()
    }
}