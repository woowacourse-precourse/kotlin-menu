package menu.domain

import camp.nextstep.edu.missionutils.Randoms
import menu.model.Coach
import menu.model.Recommendation
import menu.values.Menu

class Generator {

    private val recommendations: MutableList<Recommendation> = mutableListOf()

    fun makeRecommendations(days: List<String>, coaches: List<Coach>): List<Recommendation> {
        repeat(days.size) { index ->
            recommendations.add(makeRecommendation(days[index], coaches))
        }

        return recommendations
    }

    // 요일별 추천 만들기
    private fun makeRecommendation(day: String, coaches: List<Coach>): Recommendation {
        val category = makeCategory(day, coaches)
        val coachMenus: MutableList<Pair<String,String>> = mutableListOf()

        repeat(coaches.size) { index ->
            val menu: String = makeMenu(category, coaches[index])
            coachMenus.add(Pair(coaches[index].getName(), menu))
        }

        return Recommendation(day, category, coachMenus)
    }

    private fun makeCategory(day: String, coaches: List<Coach>): String {
        while (true) {
            val category = getCategoryName(Randoms.pickNumberInRange(1, 5)) // todo 상수화
            return category
            //todo if (isAvailableCategory(day, category)) return category
        }
    }

    private fun makeMenu(category: String, coach: Coach): String {
        var menus: MutableList<String> = mutableListOf()
        Menu.values().forEach { it ->
            if (it.name_ko == category) menus = it.menus.toMutableList()
        }

        while (true) {
            val randomMenu = Randoms.shuffle(menus)[0]
            if (isAvailableMenu(coach, randomMenu)) return randomMenu
            return randomMenu
        }
    }

    private fun makeMenus(category: String, coach: Coach): List<String> {
        val menus: MutableList<String> = mutableListOf()

        while (true) {
            val menu = getMenu(category)
            val randomMenuName = Randoms.shuffle(menu.menus)[0]
            menus.add(randomMenuName)
            return menus
            //todo if (isAvailableMenu(coach, randomMenuName)) return randomMenuName
        }
    }

//    private fun isAvailableCategory(coach: String, category: String): Boolean {
//        val menu = getMenu(category)
//        val categoryCount = coach.countContainsRecommends(menu.menus)
//        return categoryCount <= 2
//        // todo 상수화
//    }

    private fun isAvailableMenu(coach: Coach, menu: String): Boolean {
        if (coach.containsCantEatMenu(menu)) return false
        //if (coach.containsRecommend(menu)) return false

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