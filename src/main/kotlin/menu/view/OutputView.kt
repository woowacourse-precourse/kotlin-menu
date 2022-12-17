package menu.view

import menu.common.Category
import menu.common.DayOfTheWeek
import menu.domain.Coach

private const val START = "점심 메뉴 추천을 시작합니다."
private const val NAME_INPUT_REQUEST = "\n코치의 이름을 입력해 주세요. (, 로 구분)"
private const val INEDIBLE_FOOD_INPUT_REQUEST = "(이)가 못 먹는 메뉴를 입력해 주세요."
private const val MENU_SUGGEST_RESULT = "\n메뉴 추천 결과입니다."
private const val SUGGEST_COMPLETED = "\n추천을 완료했습니다."
private const val DIVISION = "구분"
private const val CATEGORY = "카테고리"
private const val SEPARATOR = " | "
private const val PREFIX = "[ "
private const val POSTFIX = " ]"
private const val ERROR = "[ERROR] "

class OutputView {

    fun showStart() {
        println(START)
    }

    fun requestInputName() {
        println(NAME_INPUT_REQUEST)
    }

    fun requestInputInedibleFood(coach: String) {
        println()
        println(coach + INEDIBLE_FOOD_INPUT_REQUEST)
    }

    fun showResult(categories: List<Category>, coaches: Set<Coach>) {
        println(MENU_SUGGEST_RESULT)
        println(transformType(getDayOfTheWeek()))
        println(transformType(getCategories(categories)))
        showCoachSuggestion(coaches)
        println(SUGGEST_COMPLETED)
    }

    private fun getDayOfTheWeek(): List<String> {
        val days: MutableList<String> = DayOfTheWeek.getDays().toMutableList()
        return days.apply { this.add(0, DIVISION) }
    }

    private fun getCategories(categories: List<Category>): List<String> {
        val shownCategories: MutableList<String> = categories.map { it.category }.toMutableList()
        return shownCategories.apply { add(0, CATEGORY) }
    }

    private fun showCoachSuggestion(coaches: Set<Coach>) {
        coaches.forEach {
            val result: MutableList<String> = it.menus.toMutableList()
            println(transformType(result.apply { add(0, it.name) }))
        }
    }

    private fun transformType(input: List<String>): String {
        return input.joinToString(SEPARATOR, PREFIX, POSTFIX)
    }

    fun showErrorMessage(message: String) {
        println(ERROR + message)
    }
}
