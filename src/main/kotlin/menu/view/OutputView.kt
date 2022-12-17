package menu.view

import menu.domain.MenuRecommender

class OutputView {

    fun printStartMessage() {
        println("점심 메뉴 추천을 시작합니다.")
    }

    fun printResult(result: MenuRecommender.Result) {
        println("메뉴 추천 결과입니다.")
        println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]")
        val categories = result.categories.joinToString(SEPARATOR)
        println("[ 카테고리 | $categories ]")
        val coachToMenus = result.coachToMenus
        for ((coach, menus) in coachToMenus) {
            println("[ ${coach.name} | ${menus.joinToString(SEPARATOR)} ]")
        }
        println("추천을 완료했습니다.")
    }

    fun printException(e: Exception) {
        println("[ERROR] ${e.message}")
    }

    companion object {
        private const val SEPARATOR = " | "
    }
}