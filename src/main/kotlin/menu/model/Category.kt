package menu.model

import java.io.FileReader

enum class Category(private val category: String, private val path: String) {
    JAPANESE_FOOD("일식", "/Users/yundonghyeon/kotlin-menu/src/main/kotlin/menu/resource/japanese_food.md"),
    KOREAN_FOOD("한식", "/Users/yundonghyeon/kotlin-menu/src/main/kotlin/menu/resource/korean-food.md"),
    CHINESE_FOOD("중식", "/Users/yundonghyeon/kotlin-menu/src/main/kotlin/menu/resource/chinese_food.md"),
    ASIAN_FOOD("아시안", "/Users/yundonghyeon/kotlin-menu/src/main/kotlin/menu/resource/asian_food.md"),
    WESTERN_FOOD("양식", "/Users/yundonghyeon/kotlin-menu/src/main/kotlin/menu/resource/western_food.md");

    fun getCategoryFoods(): String {
        return FileReader(this.path).readText()
    }

    fun getCategoryName(): String {
        return category
    }
}
