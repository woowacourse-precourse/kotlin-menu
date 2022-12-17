package menu

import java.lang.StringBuilder

class OutputView {
    fun menuSuggestionStart() = println(MENU_SUGGESTION_START)
    fun menuSuggestionResult(coaches: List<Coach>) {
        println(MENU_SUGGESTION_RESULT)
        println(DAY_OF_THE_WEEK)
        println(CATEGORY)
        coaches.forEach { printCoachMenu(it) }
        println(SUGGESTION_END)
    }

    private fun printCoachMenu(coach: Coach) {
        val resultMenu = StringBuilder("[ ${coach.name} |")
        for (i in 0 until 5) {
            resultMenu.append(" ${coach.menu[i]} ")
            if (i != 4) resultMenu.append("|")
            else resultMenu.append("]")
        }
        println(resultMenu)
    }

    companion object {
        private const val MENU_SUGGESTION_START = "점심 메뉴 추천을 시작합니다.\n"
        private const val MENU_SUGGESTION_RESULT = "메뉴 추천 결과입니다.\n"
        private const val DAY_OF_THE_WEEK = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"
        private const val CATEGORY = "[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]"
        private const val SUGGESTION_END = "\n추천을 완료했습니다."
    }
}