package menu.domain

import camp.nextstep.edu.missionutils.Randoms
import menu.data.*

class RandomCategoryGenerator {
    private val categories: List<String> = listOf(
        JAPANESE_FOOD,
        KOREAN_FOOD,
        CHINESE_FOOD,
        ASIAN_FOOD,
        WESTERN_FOOD
    )

    fun createRandomCategory(): MutableList<String> {
        val categoryContainer = mutableListOf<String>()

        while (categoryContainer.size < FIVE) {
            val category = categories[Randoms.pickNumberInRange(ZERO, FOUR)]
            categoryContainer.add(category)
        }
        return categoryContainer
    }

    companion object {
        const val ZERO = 0
        const val FOUR = 4
        const val FIVE = 5
    }
}