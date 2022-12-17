package menu.domain

import menu.domain.model.FoodCategory
import menu.domain.model.Weekday
import menu.domain.model.WeeklyCategory

class CategoryRecommandService(
    private val numberGenerator: GenerateNumber
) {

    fun recommandCategory(): FoodCategory = FoodCategory.categoryOf(numberGenerator.generate())

    /**
     * 중복되는 카테고리가 각각 2개 이하일 때 까지 식단을 재생성한다.
     */
    fun generateWeekCategory(): WeeklyCategory {
        var weeklyCategory: WeeklyCategory
        do {
            weeklyCategory = setWeeklyCategory()
        } while (weeklyCategory.hasDuplicatedCategory())
        return weeklyCategory
    }

    /**
     * 월요일부터 금요일까지의 식단을 작성한다.
     */
    private fun setWeeklyCategory() = WeeklyCategory(
        listOf(
            Weekday.MONDAY(recommandCategory()),
            Weekday.TUESDAY(recommandCategory()),
            Weekday.WEDNESDAY(recommandCategory()),
            Weekday.THURSDAY(recommandCategory()),
            Weekday.FRIDAY(recommandCategory()),
        )
    )

}