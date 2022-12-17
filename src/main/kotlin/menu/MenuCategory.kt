package menu

import java.lang.IllegalArgumentException

enum class MenuCategory {
    JAPANESE_FOOD,
    KOREAN_FOOD,
    CHINESE_FOOD,
    ASIAN_FOOD,
    WESTERN_FOOD;

    companion object {
        private const val RANDOM_SHOULD_IN_ONE_TO_FIVE = "[ERROR] 랜덤 생성 번호는 1에서 5 사이여야 합니다."
        private const val ONE = 1
        fun judgeMenuCategory(randomNumber: Int): String {
            return values().find { it.ordinal == randomNumber - ONE }?.name
                ?: throw IllegalArgumentException(RANDOM_SHOULD_IN_ONE_TO_FIVE)
        }
    }
}

