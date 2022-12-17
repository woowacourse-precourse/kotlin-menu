package menu.domain

import camp.nextstep.edu.missionutils.Randoms

class MenuRecommender {
    data class Result(val categories: Categories, val coachToMenus: Map<Coach, List<Menu>>)

    fun recommend(coach: Coach, category: Category) {
        var menu = recommend(category)
        while (coach.selectMenu(menu).not()) {
            menu = recommend(category)
        }
    }

    private fun recommend(category: Category): Menu {
        val menus = Menu.availableMenus.filter { it.category == category }.map { it.name }
        val menuName = Randoms.shuffle(menus)[0]
        return Menu(menuName, category)
    }
}