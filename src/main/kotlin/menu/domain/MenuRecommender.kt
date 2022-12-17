package menu.domain

import camp.nextstep.edu.missionutils.Randoms

class MenuRecommender(private val availableMenus: Map<Category, List<String>>) {

    fun recommend(category: Category): Menu {
        val menus = availableMenus[category]
        val menuName = Randoms.shuffle(menus)[0]
        return Menu(menuName, category)
    }
}