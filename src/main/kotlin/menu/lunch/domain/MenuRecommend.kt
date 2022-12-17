package menu.lunch.domain

class MenuRecommend {
    val coaches = mutableListOf<Coach>()

    fun addCoach(nameOfCoaches: List<String>) {
        nameOfCoaches.forEach { coaches.add(Coach(it)) }
    }

    fun addDislikedFood(name: String, foods: List<String>) {
        foods.forEach { food ->
            coaches.find { coach -> coach.isName(name) }?.addDislikedFood(food)
        }
    }
}
