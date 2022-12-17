package menu.model

class Coaches {
    val coaches = mutableListOf<Coach>()
    fun addCoach(coach:Coach){
        coaches.add(coach)
    }
}