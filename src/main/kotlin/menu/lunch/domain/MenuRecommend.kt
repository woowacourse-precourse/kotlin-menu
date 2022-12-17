package menu.lunch.domain

class MenuRecommend {
    val coaches = mutableListOf<Coach>()

    fun addCoach(nameOfCoaches: List<String>) {
        nameOfCoaches.forEach { coaches.add(Coach(it)) }
    }
}
