package menu

import  camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import camp.nextstep.edu.missionutils.Randoms.shuffle

class RandomMenu {
    fun getRecommendResult(coaches: MutableList<Coach>) {
        for (coach in coaches) {
            getRecommendMenus(coach)
        }
    }

    private fun getRecommendMenus(coach: Coach) {
        for (i in 1..5) {
            val categoryMenus = getMenus(coach)
            getRecommendMenu(coach, categoryMenus)
        }

    }

    private fun getMenus(coach: Coach): List<String> {
        val randomNumber = pickNumberInRange(1, 5)
        if (coach.getCategoriesCount(randomNumber) >= 2) {
            return getMenus(coach)
        }
        return when (randomNumber) {
            1 -> MenuCategory.JAPANESE.getMenus()
            2 -> MenuCategory.KOREAN.getMenus()
            3 -> MenuCategory.CHINESE.getMenus()
            4 -> MenuCategory.ASIAN.getMenus()
            5 -> MenuCategory.WESTERN.getMenus()
            else -> throw IllegalArgumentException()
        }
    }

    private fun getRecommendMenu(coach: Coach, categoryMenus: List<String>) {
        val menu: String = shuffle(categoryMenus)[0]
        if (menu in coach.getRecommendedMenu()) {
            return getRecommendMenu(coach, categoryMenus)
        }
        coach.saveRecommendMenus(menu)
    }
}