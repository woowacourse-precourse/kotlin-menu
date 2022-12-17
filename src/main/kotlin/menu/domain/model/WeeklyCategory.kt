package menu.domain.model

import menu.util.*
import menu.util.ERROR.WRONG_NUMBER_WEEKDAY
import java.lang.StringBuilder

class WeeklyCategory(private val weeklyCategory: List<Weekday>) : List<Weekday> by weeklyCategory {

    init {
        validateWeeklyCategory()
    }

    override fun toString(): String {
        val stringbuilder = StringBuilder()
        stringbuilder.append(LEFT_BRACKET)
        stringbuilder.append(CATEGORY)
        stringbuilder.append(SEPERATOR)
        for (i in weeklyCategory.indices) {
            stringbuilder.append(weeklyCategory[i].getCategory().getCategoryName())
            if (i == weeklyCategory.size - ONE) continue
            stringbuilder.append(SEPERATOR)
        }
        stringbuilder.append(RIGHT_BRACKET)
        return stringbuilder.toString()
    }

    private fun validateWeeklyCategory() {
        require(weeklyCategory.size == NUMBER_OF_WEEKDAY) {
            WRONG_NUMBER_WEEKDAY
        }
    }

    /**
     * 한주의 같은 카테고리는 2개이하로 설정 가능하다
     */
    fun hasDuplicatedCategory(): Boolean {
        FoodCategory.values().forEach { category ->
            if (weeklyCategory.count { it.getCategory() == category } > MAX_CATEGORY_COUNT) {
                return true
            }
        }
        return false
    }

    companion object {
        const val NUMBER_OF_WEEKDAY = 5
        const val MAX_CATEGORY_COUNT = 2
    }
}