package menu.domain.model

data class Food(
    private val foodCategory: FoodCategory,
    private val name: String
) {
    init {
        require(foodCategory.containsFood(name)) {
            "잘못된 음식을 입력하셨습니다."
        }
    }

}