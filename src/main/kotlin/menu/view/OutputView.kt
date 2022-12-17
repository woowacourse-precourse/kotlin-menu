package menu.view

import menu.domain.MenuRecommender

class OutputView {

    fun printStartMessage() {
        println("점심 메뉴 추천을 시작합니다.")
    }

    fun printResult(result: MenuRecommender.Result) {
        println("메뉴 추천 결과입니다.")
        println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]")
        val categories = result.categories.joinToString("|")
        println("[ $categories ]")
        val coachToMenus = result.coachToMenus
        for ((coach, menus) in coachToMenus) {
            println("[ ${coach.name} $SEPARATOR ${menus.joinToString(SEPARATOR)} ]")
        }
        println("추천을 완료했습니다.")
    }

    companion object {
        private const val SEPARATOR = "|"
    }
}