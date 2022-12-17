package menu.model

import menu.values.Category

class Coaches {
    val coaches = mutableListOf<Coach>()
    fun addCoach(coach: Coach) {
        coaches.add(coach)
    }

    fun recommendCoachesMenu(weeklyCategory: List<Category>) {
        repeat(weeklyCategory.size) { index ->
            repeat(coaches.size) { coach ->
                coaches[coach].setWeeklyMenu(weeklyCategory[index])
            }
        }
    }
}