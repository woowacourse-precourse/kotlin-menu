package menu.domain

import camp.nextstep.edu.missionutils.Randoms
import menu.data.*

class RandomCategoryGenerator {
    private val categories: List<String> = listOf(
        "",
        JAPANESE_FOOD,
        KOREAN_FOOD,
        CHINESE_FOOD,
        ASIAN_FOOD,
        WESTERN_FOOD
    )

    fun createRandomCategory(): MutableList<String> {
        val categoryContainer = mutableListOf<String>()

        while (categoryContainer.size < FIVE) {
            val category = categories[Randoms.pickNumberInRange(ONE, FIVE)]
            categoryContainer.add(category)
        }
        return categoryContainer
    }

    companion object {
        const val ONE = 1
        const val FIVE = 5
    }
}