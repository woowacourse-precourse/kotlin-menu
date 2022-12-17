package menu.domain

class MenuRecommend {
    val coaches = mutableListOf<Coach>()
    val logOfCategory = mutableListOf<String>()

    fun addCoach(nameOfCoaches: List<String>) {
        nameOfCoaches.forEach { coaches.add(Coach(it)) }
    }

    fun addDislikedFood(name: String, foods: List<String>) {
        foods.forEach { food ->
            coaches.find { coach -> coach.isName(name) }?.addDislikedFood(food)
        }
    }

    fun isEatSameCategoryMany(category: String) = logOfCategory.count { it == category } >= 2

    fun addCategoryRecord(category: FoodCategory) {
        logOfCategory.add(category.category)
        coaches.forEach { coach ->
            coach.eatFood(category)
        }
    }
}
