package menu.lunch.domain

class Coach(val name: String) {
    private val dislikedFood = mutableListOf<String>()

    fun addDislikedFood(food: String) {
        dislikedFood.add(food)
    }

    private fun isDislikedFood(food: String) = dislikedFood.contains(food)

    fun isName(name: String) = this.name == name
}
