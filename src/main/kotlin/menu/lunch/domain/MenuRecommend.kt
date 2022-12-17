package menu.lunch.domain

class MenuRecommend {
    val coaches = mutableListOf<Coach>()
    val categoryRecord = mutableListOf<String>()

    fun addCoach(nameOfCoaches: List<String>) {
        nameOfCoaches.forEach { coaches.add(Coach(it)) }
    }

    fun addDislikedFood(name: String, foods: List<String>) {
        foods.forEach { food ->
            coaches.find { coach -> coach.isName(name) }?.addDislikedFood(food)
        }
    }

    fun isEatSameCategoryMany(category: String) = categoryRecord.count { it == category } >= 2

    fun addCategoryRecord(category: FoodCategory) {
        categoryRecord.add(category.category)
        coaches.forEach { coach ->
            coach.eatFood(category)
        }
    }
}
