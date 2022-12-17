package menu

import camp.nextstep.edu.missionutils.Randoms
import menu.model.Category
import menu.model.DayOfWeek

object MenuRecommender {

    fun recommendMenuTable(
        foodTable: Map<DayOfWeek, Category>,
        cantEatMenu: Map<String, List<String>>
    ): Map<String, Map<DayOfWeek, String>> {
        val recommendedMenuTable = mutableMapOf<String, Map<DayOfWeek, String>>()

        val coaches = cantEatMenu.keys

        coaches.forEach { coach ->
            recommendedMenuTable[coach] = recommendMenusForCoach(foodTable, cantEatMenu[coach]!!)
        }

        return recommendedMenuTable
    }

    private fun recommendMenusForCoach(
        foodTable: Map<DayOfWeek, Category>,
        cantEatMenu: List<String>
    ): Map<DayOfWeek, String> {
        val recommendedMenus = mutableMapOf<DayOfWeek, String>()
        DayOfWeek.values().forEach { day ->
            val category = foodTable[day]
            var menu: String
            do {
                menu = Randoms.shuffle(category!!.menes)[0]
            } while (recommendedMenus.values.contains(menu) || cantEatMenu.contains(menu))
            recommendedMenus[day] = menu
        }
        return recommendedMenus
    }

}