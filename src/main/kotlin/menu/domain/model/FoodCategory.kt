package menu.domain.model

import menu.util.*
import java.lang.IllegalArgumentException

enum class FoodCategory(foodList: List<String>) {
    KOREAN(KOREAN_FOODS),
    JAPANENSE(JAPANESE_FOODS),
    CHINESE(CHINESE_FOODS),
    ASIAN(ASIAN_FOODS),
    WESTERN(WESTERN_FOODS);

    companion object {
        fun categoryOf(category: Int): FoodCategory {
            return when (category) {
                1 -> JAPANENSE
                2 -> KOREAN
                3 -> CHINESE
                4 -> ASIAN
                5 -> WESTERN
                else -> throw IllegalArgumentException("잘못된 카테고리 번호입니다.")
            }
        }
    }

}