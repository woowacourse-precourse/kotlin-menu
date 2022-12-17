package menu

import camp.nextstep.edu.missionutils.Randoms
import menu.model.Category
import menu.model.Coach
import menu.model.DayOfWeek
import menu.model.Menu

object MenuRecommender {

    fun recommendMenus(coaches: List<Coach>) {
        DayOfWeek.values().forEach { day ->
            var category: Category
            do {
                val number = Randoms.pickNumberInRange(1, 5)
                category = Category.values().first { it.number == number }
            } while (coaches.any { it.recommendedTooManyCategory(category) })
            coaches.forEach { coach -> recommendMenu(day, coach, category) }
        }
    }

    private fun recommendMenu(day: DayOfWeek, coach: Coach, category: Category) {
        var menu: String
        do {
            menu = Randoms.shuffle(category.menus.map { it.name })[0]
        } while (coach.cantEat(Menu(menu)) || coach.recommended(Menu(menu)))
        coach.recommendMenu(day, Menu(menu))
    }
}