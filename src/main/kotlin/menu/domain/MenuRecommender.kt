package menu.domain

import camp.nextstep.edu.missionutils.Randoms

class MenuRecommender(private val coaches: Coaches) {
    data class Result(val categories: List<Category>, val coachToMenus: Map<Coach, List<Menu>>)

    private val categories = Categories()

    fun recommendAll(time: Int): Result {
        repeat(time) {
            val category = categories.addRandomCategory()
            coaches.coaches.forEach {
                recommend(it, category)
            }
        }
        return makeResult(categories, coaches)
    }

    private fun recommend(coach: Coach, category: Category) {
        var menu = makeRandomMenu(category)
        while (coach.addSelectedMenu(menu).not()) {
            menu = makeRandomMenu(category)
        }
    }

    private fun makeRandomMenu(category: Category): Menu {
        val menus = Menu.existMenus.filter { it.category == category }.map { it.name }
        val menuName = Randoms.shuffle(menus)[0]
        return Menu(menuName, category)
    }

    private fun makeResult(categories: Categories, coaches: Coaches): Result {
        val result = coaches.coaches
            .associateWith { it.selectedMenus.toList() }
        return Result(categories.selectedCategories, result)
    }
}
