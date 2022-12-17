package menu.model

import menu.values.Category

class Coaches {
    private val coaches = mutableListOf<Coach>()
    fun addCoach(coach:Coach){
        coaches.add(coach)
    }

    fun recommendCoachesMenu(weeklyCategory: List<Category>){
        repeat(coaches.size){index->
            coaches[index].setWeeklyMenu(weeklyCategory)
        }
        repeat(coaches.size){index->
            println(coaches[index].weeklyMenus)
        }
    }
}