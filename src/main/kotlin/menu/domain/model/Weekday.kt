package menu.domain.model

sealed class Weekday {
    class MONDAY(category: FoodCategory)
    class TUESDAY(category: FoodCategory)
    class WEDNESDAY(category: FoodCategory)
    class THURSDAY(category: FoodCategory)
    class FRIDAY(category: FoodCategory)

}