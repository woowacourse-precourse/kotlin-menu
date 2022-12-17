package menu.view

import menu.Coach
import menu.MenuCategory

class OutputView {
    fun printStartMessage() {
        println(START_MESSAGE)
    }

    fun requestCoachNames() {
        println(REQUEST_COACH_NAME_MESSAGE)
    }

    fun requestCoachBias(coach: Coach) {
        println(coach.getName() + REQUEST_COACH_BIAS_MESSAGE)
    }

    fun printResultMessage() {
        println(RESULT_MENU_MESSAGE)
    }

    fun printEndMessage() {
        println(END_MESSAGE)
    }

    fun printRecommendResult(coaches: MutableList<Coach>) {
        val stringBuilder = StringBuilder()
        stringBuilder.append(DAYS_MESSAGE)
        stringBuilder.append(LEFT_BRACKET + CATEGORY + VERTICAL_LINE + MenuCategory.getCategories().joinToString { VERTICAL_LINE } + RIGHT_BRACKET)
        for (coach in coaches) {
            stringBuilder.append(LEFT_BRACKET + coach.getName() + VERTICAL_LINE + coach.getRecommendedMenu().joinToString { VERTICAL_LINE } + RIGHT_BRACKET)
        }
        println(stringBuilder)
    }

    companion object {
        const val START_MESSAGE = "점심 메뉴 추천을 시작합니다."
        const val REQUEST_COACH_NAME_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)"
        const val REQUEST_COACH_BIAS_MESSAGE = "(이)가 못 먹는 메뉴를 입력해 주세요."
        const val RESULT_MENU_MESSAGE = "메뉴 추천 결과입니다."
        const val END_MESSAGE = "추천을 완료했습니다."
        const val VERTICAL_LINE = " | "
        const val LEFT_BRACKET = "[ "
        const val RIGHT_BRACKET = " ]"
        const val CATEGORY = "카테고리"
        const val DAYS_MESSAGE = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"

    }
}