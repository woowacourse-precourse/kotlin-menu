package menu.domain

import menu.data.*

class MenuCreator(private val categoryContainer: MutableList<String>) {
    private val randomFoodGenerator = RandomFoodGenerator()
    private val foodContainer = mutableListOf<String>()

    fun readCategory(): MutableList<String> {
        for (category in categoryContainer.indices) {
            when (categoryContainer[category]) {
                JAPANESE_FOOD -> foodContainer.add(randomFoodGenerator.recommendJapaneseFood())
                KOREAN_FOOD -> foodContainer.add(randomFoodGenerator.recommendKoreanFood())
                CHINESE_FOOD -> foodContainer.add(randomFoodGenerator.recommendChineseFood())
                ASIAN_FOOD -> foodContainer.add(randomFoodGenerator.recommendAsianFood())
                WESTERN_FOOD -> foodContainer.add(randomFoodGenerator.recommendWesternFood())
            }
        }

        return foodContainer
    }

}