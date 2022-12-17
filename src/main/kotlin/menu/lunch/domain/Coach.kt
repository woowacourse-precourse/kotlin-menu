package menu.lunch.domain

class Coach(val name: String) {
    private val dislikedFood = mutableListOf<String>()
    val alreadyEatFood = mutableListOf<String>()

    fun eatFood(category: FoodCategory): String {
        val randomMenu = RandomMenu().getRandomMenu(category)
        val food = randomMenu
            .first { food ->
                !isDislikedFood(food) && !isAlreadyEatFood(food)
            }
        alreadyEatFood.add(food)
        return food
    }

    fun addDislikedFood(food: String) {
        dislikedFood.add(food)
    }

    private fun isDislikedFood(food: String) = dislikedFood.contains(food)
    private fun isAlreadyEatFood(food: String) = alreadyEatFood.contains(food)

    fun isName(name: String) = this.name == name
}
