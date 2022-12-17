package menu.domain

import camp.nextstep.edu.missionutils.Randoms
import menu.model.Coach
import menu.values.Menu

class Generator {

    fun makeRecommendation(coach: Coach): String {
        val category = makeCategory(coach)

        return ""
    }

    private fun makeCategory(coach: Coach): String {
        while (true) {
            val category = getCategoryName(Randoms.pickNumberInRange(1, 5)) // todo 상수화
            if (isAvailableCategory(coach, category)) return category
        }
    }

    private fun isAvailableCategory(coach: Coach, category: String): Boolean {
        var categoryCount = 0

        Menu.values().forEach { menu ->
            if (menu.name_ko == category) {
                if (coach.containsRecommends(menu.menus)) categoryCount++
            }
        }

        return categoryCount < 2
        //todo 상수화
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


}