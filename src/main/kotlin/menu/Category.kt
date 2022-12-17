package menu

enum class Category(val index: Int, val categoryName: String) {
    JAPANESE_FOOD(1, "일식"),
    KOREAN_FOOD(2, "한식"),
    CHINESE_FOOD(3, "중식"),
    ASIAN_FOOD(4, "아시안"),
    WESTERN_FOOD(5, "양식"),
}

object FindCategoryByValue {
    private val map = Category.values().associateBy(Category::index)
    fun fromValue(value: Int) = map[value]
}