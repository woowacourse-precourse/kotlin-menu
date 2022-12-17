package menu

import java.lang.StringBuilder

class OutputView {
    fun menuSuggestionStart() = println(MENU_SUGGESTION_START)
    fun menuSuggestionResult(coaches: List<Coach>, category: List<Category>) {
        println(MENU_SUGGESTION_RESULT)
        println(DAY_OF_THE_WEEK)
        printCategory(category)
        coaches.forEach { printCoachMenu(it) }
        print(SUGGESTION_END)
    }

    private fun printCoachMenu(coach: Coach) {
        val resultMenu = StringBuilder("[ ${coach.name} |")
        for (i in 0 until SuggestionMenu.HIGH_DAY) {
            resultMenu.append(" ${coach.menus[i]} ")
            if (i != SuggestionMenu.HIGH_DAY - 1) resultMenu.append("|")
            else resultMenu.append("]")
        }
        println(resultMenu)
    }

    private fun printCategory(category: List<Category>) {
        val resultCategory = StringBuilder("[ 카테고리 |")
        for (i in 0 until SuggestionMenu.HIGH_CATEGORY) {
            resultCategory.append(" ${category[i].categoryName} ")
            if (i != SuggestionMenu.HIGH_CATEGORY - 1) resultCategory.append("|")
            else resultCategory.append("]")
        }
        println(resultCategory)
    }


    companion object {
        private const val MENU_SUGGESTION_START = "점심 메뉴 추천을 시작합니다.\n"
        private const val MENU_SUGGESTION_RESULT = "\n메뉴 추천 결과입니다."
        private const val DAY_OF_THE_WEEK = "\n[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"
        private const val SUGGESTION_END = "\n추천을 완료했습니다."
    }
}