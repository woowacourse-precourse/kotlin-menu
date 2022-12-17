package menu.domain

import menu.resources.ASIAN_FOOD_CATEGORY
import menu.resources.ASIAN_FOOD_MENU
import menu.resources.CHINESE_FOOD_CATEGORY
import menu.resources.CHINESE_FOOD_MENU
import menu.resources.JAPANESE_FOOD_CATEGORY
import menu.resources.JAPANESE_FOOD_MENU
import menu.resources.KOREAN_FOOD_CATEGORY
import menu.resources.KOREAN_FOOD_MENU
import menu.resources.WESTERN_FOOD_CATEGORY
import menu.resources.WESTERN_FOOD_MENU

enum class FoodCategory(val category: String, val menuList: List<String>) {
    JAPANESE(JAPANESE_FOOD_CATEGORY, JAPANESE_FOOD_MENU),
    KOREAN(KOREAN_FOOD_CATEGORY, KOREAN_FOOD_MENU),
    CHINESE(CHINESE_FOOD_CATEGORY, CHINESE_FOOD_MENU),
    ASIAN(ASIAN_FOOD_CATEGORY, ASIAN_FOOD_MENU),
    WESTERN(WESTERN_FOOD_CATEGORY, WESTERN_FOOD_MENU);
}
