package menu.view

import menu.WEEKS
import menu.domain.MenuRecommender

class OutputView {

    fun printStartMessage() {
        println("점심 메뉴 추천을 시작합니다.")
    }

    fun printResult(result: MenuRecommender.Result) {
        println("메뉴 추천 결과입니다.")
        println("[ 구분 | ${WEEKS.joinToString(SEPARATOR)} ]")
        val categories = result.categories.joinToString(SEPARATOR)
        println("[ 카테고리 | $categories ]")
        for ((coach, menus) in result.coachToMenus) {
            println("[ ${coach.name} | ${menus.joinToString(SEPARATOR)} ]")
        }
        println("추천을 완료했습니다.")
    }

    fun printException(e: Exception) {
        println(ERROR_MESSAGE_FORMAT.format(e.message))
    }

    companion object {
        private const val SEPARATOR = " | "
        private const val ERROR_MESSAGE_FORMAT = "[ERROR] %s"
    }
}