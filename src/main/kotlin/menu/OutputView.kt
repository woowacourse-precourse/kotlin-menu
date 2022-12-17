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
        print(FOOD_CATEGORY)
        val foods = recommendResult.toList()[0].second
        val foodCategories = FoodCategory.values().toList()
        var printCategoryCount = 0
        for (f in foods) {
            var num = 0
            for (fc in foodCategories) {
                if (fc.getFoodNames().contains(f)) {
                    if (printCategoryCount == 4) {
                        print("${getFoodCategory(num).getCategoryName()} ")
                    } else {
                        print("${getFoodCategory(num).getCategoryName()} | ")
                    }
                    break
                }
                num += 1
            }
            printCategoryCount += 1
        }
        print(END_BLANK)
        println()
        recommendResult.forEach{ it ->
            var printMenuCount = 0
            print(START_BLANK)
            print("${it.key} | ")
            for (fn in it.value) {
                if (printMenuCount == 4) {
                    print("${fn} ")
                } else {
                    print("${fn} | ")
                }
                printMenuCount += 1
            }
            print(END_BLANK)
            println()
        }
        println()
        println(RECOMMEND_FINISH)
    }

    fun getFoodCategory(num: Int): FoodCategory{
        return when (num) {
            0 -> FoodCategory.JAPANESE_FOOD
            1 -> FoodCategory.KOREAN_FOOD
            2 -> FoodCategory.CHINESE_FOOD
            3 -> FoodCategory.ASIAN_FOOD
            else -> FoodCategory.WESTERN_FOOD
        }
    }

    companion object {
        const val SERVICE_START = "서비스 시작 문구 출력"
        const val RECOMMEND_RESULT = "메뉴 추천 결과입니다."
        const val RECOMMEND_FINISH = "추천을 완료했습니다."
        const val DAYS = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"
        const val FOOD_CATEGORY = "[ 카테고리 | "
        const val START_BLANK = "[ "
        const val END_BLANK = "]"
    }


}