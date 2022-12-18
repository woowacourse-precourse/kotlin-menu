package menu.model

class Menu {

    fun getCategoryMenu(category: String): List<String> {
        var menus = listOf<String>()
        when (category) {
            "아시안" -> menus = Category.ASIAN_FOOD.getCategoryFoods().split(", ")
            "중식" -> menus = Category.CHINESE_FOOD.getCategoryFoods().split(", ")
            "일식" -> menus = Category.JAPANESE_FOOD.getCategoryFoods().split(", ")
            "한식" -> menus = Category.KOREAN_FOOD.getCategoryFoods().split(", ")
            "양식" -> menus = Category.WESTERN_FOOD.getCategoryFoods().split(", ")
        }
        return menus
    }

}