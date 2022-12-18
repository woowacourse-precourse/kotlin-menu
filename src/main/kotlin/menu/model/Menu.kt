package menu.model

import java.io.FileReader

class Menu {

    fun getCategoryMenu(category: String): String {
        var menu = ""
        when (category) {
            "아시안" -> menu = FileReader(Category.ASIAN_FOOD.getCategoryPath()).readText().split(", ").shuffled()[0]
            "중식" -> menu = FileReader(Category.CHINESE_FOOD.getCategoryPath()).readText().split(", ").shuffled()[0]
            "일식" -> menu = FileReader(Category.JAPANESE_FOOD.getCategoryPath()).readText().split(", ").shuffled()[0]
            "한식" -> menu = FileReader(Category.KOREAN_FOOD.getCategoryPath()).readText().split(", ").shuffled()[0]
            "양식" -> menu = FileReader(Category.WESTERN_FOOD.getCategoryPath()).readText().split(", ").shuffled()[0]
        }
        return menu
    }

}