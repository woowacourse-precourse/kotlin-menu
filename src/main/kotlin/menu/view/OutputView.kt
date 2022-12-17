package menu.view

import menu.domain.model.Coach
import menu.domain.model.Coaches
import menu.domain.model.WeeklyCategory

class OutputView {

    fun menuRecommandResults(weeklyCategory: WeeklyCategory, coaches: Coaches) {
        println("메뉴 추천 결과입니다.")
        println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]")
        println(weeklyCategory.toString())
        coaches.forEach { coach ->
            println(coach)
        }
    }

    fun endRecommend() {
        println("추천을 완료했습니다.")
    }
}