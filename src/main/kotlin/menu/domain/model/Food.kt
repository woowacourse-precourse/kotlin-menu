package menu.domain.model

data class Food(
    private val foodCategory: FoodCategory,
    private val name: String
) {

    fun getName() = name

}