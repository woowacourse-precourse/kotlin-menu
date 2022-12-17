package menu.model

import camp.nextstep.edu.missionutils.Randoms
import menu.values.Category
import java.util.*

class Coach(val name: String, private val hateMenu: List<String>
) {
    val weeklyMenus = mutableListOf<String>()

    fun setWeeklyMenu(categories: List<Category>) {
        repeat(categories.size) { weekDay ->
            weeklyMenus.add(pickMenu(categories[weekDay]))
        }
    }

    private fun pickMenu(category: Category): String {
        while (true) {
            val menu = Randoms.shuffle(category.menus)[0]
            if (Collections.frequency(weeklyMenus, menu) < 1) {
                return menu
            }
        }
    }
}