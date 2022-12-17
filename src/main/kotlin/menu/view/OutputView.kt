package menu.view

import menu.Category
import menu.Day
import menu.domain.Coach

class OutputView {
    fun printStart() {
        println(START_ANNOUNCEMENT)
    }

    fun printFinish() {}

    private fun printFormedDescription(elements: List<String>) {
        val description = elements.joinToString { DESCRIPTION_FORM }
        println("[ $description ]")
    }

    private fun printDivision() {
        val days = listOf(DIVISION_HEADER) + Day.values().map { day -> day.byKorean() }
        printFormedDescription(days)
    }

    private fun printCategory(categories: List<Category>) {
        val daysByKorean = listOf(CATEGORY_HEADER) + categories.map { category -> category.byKorean() }
        printFormedDescription(daysByKorean)
    }

    private fun printMenus(coach: Coach) {
        val recommendResult = coach.getRecommendResult()
        printFormedDescription(recommendResult)
    }

    companion object {
        const val CATEGORY_HEADER = "카테고리"
        const val DESCRIPTION_FORM = " | "
        const val DIVISION_HEADER = "구분"
        const val START_ANNOUNCEMENT = "점심 메뉴 추천을 시작합니다."
    }
}