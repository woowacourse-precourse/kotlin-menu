package menu.lunch.domain

import menu.lunch.resources.ASIAN_FOOD_CATEGORY
import menu.lunch.resources.ASIAN_FOOD_MENU
import menu.lunch.resources.CHINESE_FOOD_CATEGORY
import menu.lunch.resources.CHINESE_FOOD_MENU
import menu.lunch.resources.JAPANESE_FOOD_CATEGORY
import menu.lunch.resources.JAPANESE_FOOD_MENU
import menu.lunch.resources.KOREAN_FOOD_CATEGORY
import menu.lunch.resources.KOREAN_FOOD_MENU
import menu.lunch.resources.WESTERN_FOOD_CATEGORY
import menu.lunch.resources.WESTERN_FOOD_MENU

enum class FoodCategory(val category: String, val menuList: List<String>) {
    JAPANESE(JAPANESE_FOOD_CATEGORY, JAPANESE_FOOD_MENU),
    KOREAN(KOREAN_FOOD_CATEGORY, KOREAN_FOOD_MENU),
    CHINESE(CHINESE_FOOD_CATEGORY, CHINESE_FOOD_MENU),
    ASIAN(ASIAN_FOOD_CATEGORY, ASIAN_FOOD_MENU),
    WESTERN(WESTERN_FOOD_CATEGORY, WESTERN_FOOD_MENU);
}
