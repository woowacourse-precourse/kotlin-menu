package menu.domain

import  camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import camp.nextstep.edu.missionutils.Randoms.shuffle
import menu.data.Coach
import menu.data.MenuCategory

class RandomMenu {
    private var categoryCount = mutableListOf(0, 0, 0, 0, 0)
    private var categoryNames = mutableListOf<String>()

    fun getRecommendMenus(coaches: MutableList<Coach>): MutableList<String> {
        for (i in RANGE_START..RANGE_END) {
            val categoryMenus = getCategoryMenus()
            for (coach in coaches) {
                getRecommendMenus(coach, categoryMenus)
            }
        }
        return categoryNames
    }

    private fun getCategoryMenus(): List<String> {
        val randomNumber = pickNumberInRange(RANGE_START, RANGE_END)
        if (categoryCount[randomNumber - 1] >= DUPLICATE_COUNT) {
            return getCategoryMenus()
        }
        categoryCount[randomNumber - 1] += 1
        categoryNames.add(MenuCategory.getCategoryName(randomNumber))
        return MenuCategory.getMenus(randomNumber)
    }

    private fun getRecommendMenus(coach: Coach, categoryMenus: List<String>) {
        val menu: String = shuffle(categoryMenus)[FIRST_VALUE]
        if (menu in coach.getRecommendedMenu() || menu in coach.getBias()) {
            return getRecommendMenus(coach, categoryMenus)
        }
        coach.saveRecommendMenus(menu)
    }

    companion object {
        const val RANGE_START = 1
        const val RANGE_END = 5
        const val DUPLICATE_COUNT = 2
        const val FIRST_VALUE = 0
    }
}