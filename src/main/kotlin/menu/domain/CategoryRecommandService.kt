package menu.domain

import menu.domain.model.FoodCategory
import menu.domain.model.Weekday
import menu.domain.model.WeeklyCategory

class CategoryRecommandService(
    private val numberGenerator: GenerateNumber
) {

    fun recommandCategory(): FoodCategory = FoodCategory.categoryOf(numberGenerator.generate())

    fun generateWeekCategory(): WeeklyCategory {
        var weeklyCategory: WeeklyCategory
        do {
            weeklyCategory = setWeeklyCategory()
        } while (weeklyCategory.hasDuplicatedCategory())
        return weeklyCategory
    }

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