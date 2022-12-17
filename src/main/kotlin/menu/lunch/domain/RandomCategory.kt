package menu.lunch.domain

import camp.nextstep.edu.missionutils.Randoms

class RandomCategory {
    private val categories = FoodCategory.values()
    fun getRandomCategory() = categories[Randoms.pickNumberInRange(1, 5) - 1]
}
