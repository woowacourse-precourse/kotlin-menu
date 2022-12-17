package menu.view

import menu.util.*

class OutputView {

    // 코치별 추천 받은 음식 물자열로 변환
    private fun convertCoachMenuToString(coach: String, weeklyCoachMenu: MutableList<String>): String {
        val coachMenus = mutableListOf(coach)
        weeklyCoachMenu.forEach { menu ->
            coachMenus.add(menu)
        }
        return coachMenus.joinToString(SEPARATOR, PREFIX, POSTFIX)
    }

    // 요구사항에 맞게 카테고리 문자열로 변환
    private fun convertCategoryToString(categories: MutableList<Int>): String {
        val result = mutableListOf(CATEGORY)
        categories.forEach { category ->
            result.add(numberToCategory(category))
        }
        return result.joinToString(SEPARATOR, PREFIX, POSTFIX)
    }

    private fun numberToCategory(category: Int): String {
        return when (category) {
            1 -> JAPAN
            2 -> KOREAN
            3 -> CHINESE
            4 -> ASIAN
            5 -> AMERICA
            else -> { throw IllegalArgumentException(ERROR_HEADER + ERROR_CATEGORY_NUMBER)}
        }
    }
}