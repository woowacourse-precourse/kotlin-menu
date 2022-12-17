package menu.domain.model

import menu.util.LEFT_BRACKET
import menu.util.RIGHT_BRACKET
import menu.util.SEPERATOR
import java.lang.StringBuilder

class WeeklyCategory(private val weeklyCategory: List<Weekday>) : List<Weekday> by weeklyCategory {

    init {
        validateWeeklyCategory()
    }

    override fun toString(): String {
        val stringbuilder = StringBuilder()
        stringbuilder.append(LEFT_BRACKET)
        for (i in weeklyCategory.indices) {
            stringbuilder.append(weeklyCategory[i].getCategory().getCategoryName())
            if (i == weeklyCategory.size - 1) continue
            stringbuilder.append(SEPERATOR)
        }
        stringbuilder.append(RIGHT_BRACKET)
        return stringbuilder.toString()
    }

    private fun validateWeeklyCategory() {
        require(weeklyCategory.size == 5) {
            "월, 화, 수, 목, 금으로 이루어진 카테고리를 입력해 주세요."
        }
    }

    /**
     * 한주의 같은 카테고리는 2개이하로 설정 가능하다
     */
    fun hasDuplicatedCategory(): Boolean {
        if (weeklyCategory.count { it.getCategory() == FoodCategory.JAPANENSE } > 2 ||
            weeklyCategory.count { it.getCategory() == FoodCategory.KOREAN } > 2 ||
            weeklyCategory.count { it.getCategory() == FoodCategory.JAPANENSE } > 2 ||
            weeklyCategory.count { it.getCategory() == FoodCategory.WESTERN } > 2 ||
            weeklyCategory.count { it.getCategory() == FoodCategory.CHINESE } > 2) {
            return true
        }
        return false
    }

}