package menu.domain

import camp.nextstep.edu.missionutils.Randoms
import menu.model.Coach
import menu.values.Menu

class Generator {

    fun makeRecommendation(coach: Coach): String {
        val category = makeCategory(coach)

        return makeMenu(coach, category)
    }

    private fun makeMenu(coach: Coach, category: String): String {
        while (true) {
            val menu = getMenu(category)
            val randomMenuName = Randoms.shuffle(menu.menus)[0]
            if (isAvailableMenu(coach, randomMenuName)) return randomMenuName
        }
    }

    private fun makeCategory(coach: Coach): String {
        while (true) {
            val category = getCategoryName(Randoms.pickNumberInRange(1, 5)) // todo 상수화
            if (isAvailableCategory(coach, category)) return category
        }
    }

    private fun isAvailableCategory(coach: Coach, category: String): Boolean {
        val menu = getMenu(category)
        val categoryCount = coach.countContainsRecommends(menu.menus)
        return categoryCount <= 2
        // todo 상수화
    }

    private fun isAvailableMenu(coach: Coach, menu: String): Boolean {
        if (coach.containsCantEatMenu(menu)) return false
        if (coach.containsRecommend(menu)) return false

        return true
    }

    private fun getCategoryName(categoryNumber: Int): String {
        return when (categoryNumber) {
            Menu.JAPAN.number -> Menu.JAPAN.name_ko
            Menu.KOREA.number -> Menu.KOREA.name_ko
            Menu.CHINA.number -> Menu.CHINA.name_ko
            Menu.ASIA.number -> Menu.ASIA.name_ko
            Menu.WESTERN.number -> Menu.WESTERN.name_ko
            else -> ""
        }
    }

    private fun getMenu(category: String): Menu {
        Menu.values().forEach { menu ->
            if (menu.name_ko == category) return menu
        }

        // todo 다른 방법 고안 필요
        return Menu.JAPAN
    }
}