package menu.domain

import menu.utils.*

enum class Category(val value: String, val menus: List<String>) {
    JAPANESE("일식", JAPANESE_FOOD.split(", ")),
    KOREAN("한식", KOREAN_FOOD.split(", ")),
    CHINESE("중식", CHINESE_FOOD.split(", ")),
    ASIAN("아시안", ASIAN_FOOD.split(", ")),
    WESTERN("양식", WESTERN_FOOD.split(", "));


    companion object {
        fun of(value: String): Category =
            values().find { category -> category.value == value }
                ?: throw IllegalArgumentException()
    }
}