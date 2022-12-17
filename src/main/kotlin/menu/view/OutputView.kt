package menu.view

import menu.Category
import menu.Day

class OutputView {
    fun printStart() {
        println(START_ANNOUNCEMENT)
    }

    fun printFinish() {}

    private fun getFormedDescription(elements: List<String>): String {
        return elements.joinToString { DESCRIPTION_FORM }
    }

    private fun printDivision() {
        val days = listOf(DIVISION_HEADER) + Day.values().map { day -> day.byKorean() }
        val description = getFormedDescription(days)
        println("[ $description ]")
    }

    private fun printCategory(categories: List<Category>) {
        val daysByKorean = listOf(CATEGORY_HEADER) + categories.map { category -> category.byKorean() }
        val description = getFormedDescription(daysByKorean)
        println("[ $description ]")
    }

    companion object {
        const val CATEGORY_HEADER = "카테고리"
        const val DESCRIPTION_FORM = " | "
        const val DIVISION_HEADER = "구분"
        const val START_ANNOUNCEMENT = "점심 메뉴 추천을 시작합니다."
    }
}