package menu.view

import menu.model.Coach
import menu.model.Week

class OutputView {

    fun printStart() = println("점심 메뉴 추천을 시작합니다.")

    fun printInputCoachNames() = println("코치의 이름을 입력해 주세요. (, 로 구분)")

    fun printInputExcludedFood(name: String) = println("$name(이)가 못 먹는 메뉴를 입력해 주세요.")


    fun printRecommendResult(week: Week, coaches: List<Coach>) {
        println("메뉴 추천 결과입니다.")
        println("[ 구분 | ${week.getDayOfWeek().joinToString(" | ")} ]")
        println("[ 카테고리 | ${week.getCategories().joinToString(" | ")} ]")
        coaches.forEach { coach ->
            println("[ ${coach.getName()} | ${coach.getRecommendedMenus().joinToString ( " | " )} ]")
        }
    }

    fun printEnd() = println("추천을 완료했습니다.")
}