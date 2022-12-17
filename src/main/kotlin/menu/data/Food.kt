package menu.data

import menu.data.Menu.ASIAN_FOODS
import menu.data.Menu.CHINESE_FOODS
import menu.data.Menu.JAPANESE_FOODS
import menu.data.Menu.KOREAN_FOODS
import menu.data.Menu.WESTERN_FOODS

enum class Food(
    private val categoryNumber: Int,
    private val menus: String,
) {
    JAPANESE(1, JAPANESE_FOODS),
    KOREAN(2, KOREAN_FOODS),
    CHINESE(3, CHINESE_FOODS),
    ASIAN(4, ASIAN_FOODS),
    WESTERN(5, WESTERN_FOODS)
}
