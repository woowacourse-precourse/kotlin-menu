package menu

class OutputView {

    fun printBlankLine(){
        println()
    }
    fun printServiceStart() {
        println(SERVICE_START)
    }
    fun printResult(recommendResult: MutableMap<String, MutableList<String>>) {
        println(RECOMMEND_RESULT)
        println(DAYS)
        printCategory(recommendResult)
        printCoachMenus(recommendResult)
    }

    private fun printCoachMenus(recommendResult: MutableMap<String, MutableList<String>>) {
        recommendResult.forEach { it ->
            print(START_BLANK)
            print("${it.key} | ")
            for ((index,fn) in it.value.withIndex()) {
                if (index == 4) {
                    print("${fn} ")
                } else {
                    print("${fn} | ")
                }
            }
            print(END_BLANK)
            println()
        }
        println()
        println(RECOMMEND_FINISH)
    }

    private fun printCategory(recommendResult: MutableMap<String, MutableList<String>>) {
        print(FOOD_CATEGORY)
        val foods = recommendResult.toList()[0].second
        val foodCategories = FoodCategory.values().toList()
        for ((index,f) in foods.withIndex()) {
            for ((categoryNum,fc) in foodCategories.withIndex()) {
                if (fc.getFoodNames().contains(f)) {
                    if (index == 4) {
                        print("${getFoodCategory(categoryNum).getCategoryName()} ")
                    } else {
                        print("${getFoodCategory(categoryNum).getCategoryName()} | ")
                    }
                    break
                }
            }
        }
        print(END_BLANK)
        println()
    }

    private fun getFoodCategory(num: Int): FoodCategory{
        return when (num) {
            0 -> FoodCategory.JAPANESE_FOOD
            1 -> FoodCategory.KOREAN_FOOD
            2 -> FoodCategory.CHINESE_FOOD
            3 -> FoodCategory.ASIAN_FOOD
            else -> FoodCategory.WESTERN_FOOD
        }
    }

    companion object {
        const val SERVICE_START = "점심 메뉴 추천을 시작합니다."
        const val RECOMMEND_RESULT = "메뉴 추천 결과입니다."
        const val RECOMMEND_FINISH = "추천을 완료했습니다."
        const val DAYS = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"
        const val FOOD_CATEGORY = "[ 카테고리 | "
        const val START_BLANK = "[ "
        const val END_BLANK = "]"
    }


}