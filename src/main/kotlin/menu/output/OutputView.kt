package menu.output

import menu.message.PrintMessage

class OutputView {
    // TODO: 점심메뉴 추천 시작 문구 출력, 코치 이름 입력 문구 출력, 해당 코치가 못 먹는 메뉴 문구 출력, 메뉴 추천 결과 출력

    fun startRecommendMenu() {
        println(PrintMessage.startRecommend)
    }

    fun inputCoachName() {
        println(PrintMessage.inputCoachName)
    }

    fun inputNotEatMenu() {
        println(PrintMessage.inputNotEatMenu)
    }

    fun resultRecommendMenu() {
        println(PrintMessage.resultToRecommendMenu)
    }
}