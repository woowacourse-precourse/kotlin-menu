package menu.view

import menu.Category
import menu.Day

class OutputView {
    fun printStart() {
        println(START_ANNOUNCEMENT)
    }

    fun printFinish() {}



    private fun printDivision() {
        val days = Day.values().map { day -> day.byKorean() }
        val division = days.joinToString { " | " }
        println("[ 구분 | $division ]")
    }

    private fun printCategory(categories: List<Category>) {
        val byKoreans = categories.map { category -> category.byKorean() }
        val description = byKoreans.joinToString { " | " }
        println("[ 카테고리 | $description ]")
    }

    companion object {
        const val START_ANNOUNCEMENT = "점심 메뉴 추천을 시작합니다."
    }
}