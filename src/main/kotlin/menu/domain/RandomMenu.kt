package menu.domain

import  camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import camp.nextstep.edu.missionutils.Randoms.shuffle
import menu.data.Coach
import menu.data.MenuCategory

class RandomMenu {
    private var categories = mutableListOf(0, 0, 0, 0, 0)
    private var categoryNames = mutableListOf<String>()

    fun getRecommendMenus(coaches: MutableList<Coach>): MutableList<String> {
        for (i in 1..5) {
            val categoryMenus = getCategory()
            for (coach in coaches) {
                getRecommendMenu(coach, categoryMenus)
            }
        }
        return categoryNames

    }

    private fun getCategory(): List<String> {
        val randomNumber = pickNumberInRange(1, 5)
        if (categories[randomNumber-1] >= 2) {
            return getCategory()
        }
        categoryNames.add(MenuCategory.getCategoryName(randomNumber))
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