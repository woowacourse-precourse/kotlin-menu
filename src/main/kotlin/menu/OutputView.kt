package menu

import menu.FoodData.categories

class OutputView {

    fun printResults(messageCategory: String, results: List<String>) {
        print("[ $messageCategory ")
        results.forEach { eachResult ->
            print("| $eachResult ")
        }
        print("]\n")
    }

    fun printMessage(msg: String) {
        println(msg)
    }

    companion object {
        const val CATEGORY = "카테고리"
        const val MONDAY_TO_FRIDAY = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"
        const val RESULT_OF_RECOMMENDATION = "메뉴 추천 결과입니다."
        const val FINISHED = "추천을 완료했습니다."
    }
}