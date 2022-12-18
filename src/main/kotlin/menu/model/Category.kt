package menu.model

enum class Category(private val path:String){
    ASIAN_FOOD("/Users/yundonghyeon/kotlin-menu/src/main/kotlin/menu/resource/asian_food.md"),
    CHINESE_FOOD("/Users/yundonghyeon/kotlin-menu/src/main/kotlin/menu/resource/chinese_food.md"),
    JAPANESE_FOOD("/Users/yundonghyeon/kotlin-menu/src/main/kotlin/menu/resource/japanese_food.md"),
    KOREAN_FOOD("/Users/yundonghyeon/kotlin-menu/src/main/kotlin/menu/resource/korean-food.md"),
    WESTERN_FOOD("/Users/yundonghyeon/kotlin-menu/src/main/kotlin/menu/resource/western_food.md");

    fun getCategoryPath():String{
        return this.path
    }
}
