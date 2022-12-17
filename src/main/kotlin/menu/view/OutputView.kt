package menu.view

import menu.Category
import menu.Day
import menu.domain.Coach
import menu.dto.CategoriesDTO
import menu.dto.CoachesDTO

class OutputView {
    fun printStart() {
        println(START_ANNOUNCEMENT)
    }

    fun printFinish(categoriesDTO: CategoriesDTO, coachesDTO: CoachesDTO) {
        println(FINISH_ANNOUNCEMENT)
        printDivision()

        printCategory(categoriesDTO.getCategories())

        val coaches = coachesDTO.getCoaches()
        coaches.map { coach -> printMenus(coach) }
        printInterval()

        printRecommendDone()
    }

    fun printInterval() {
        println()
    }

    fun printError(errorMessage: String) {
        println("$ERROR_HEADER $errorMessage")
    }

    private fun printFormedDescription(elements: List<String>) {
        val description = elements.joinToString(DESCRIPTION_FORM)
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

    private fun printRecommendDone() {
        println(RECOMMEND_DONE_ANNOUNCEMENT)
    }

    companion object {
        const val CATEGORY_HEADER = "카테고리"
        const val DESCRIPTION_FORM = " | "
        const val DIVISION_HEADER = "구분"
        const val ERROR_HEADER = "[ERROR]"
        const val FINISH_ANNOUNCEMENT = "메뉴 추천 결과입니다."
        const val RECOMMEND_DONE_ANNOUNCEMENT = "추천을 완료했습니다."
        const val START_ANNOUNCEMENT = "점심 메뉴 추천을 시작합니다."
    }
}