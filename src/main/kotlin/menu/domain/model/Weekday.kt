package menu.domain.model

sealed class Weekday(private val category: FoodCategory) {
    class MONDAY(category: FoodCategory) : Weekday(category)
    class TUESDAY(category: FoodCategory) : Weekday(category)
    class WEDNESDAY(category: FoodCategory) : Weekday(category)
    class THURSDAY(category: FoodCategory) : Weekday(category)
    class FRIDAY(category: FoodCategory) : Weekday(category)

    fun getCategory(): FoodCategory {
        return category
    }

}