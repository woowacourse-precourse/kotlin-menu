package menu.domain.model

import menu.util.*

enum class FoodCategory(foodList: List<String>) {
    KOREAN(KOREAN_FOODS),
    JAPANENSE(JAPANESE_FOODS),
    CHINESE(CHINESE_FOODS),
    ASIAN(ASIAN_FOODS),
    WESTERN(WESTERN_FOODS);

}