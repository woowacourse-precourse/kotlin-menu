package menu.ui

import menu.data.Error
import menu.data.State.categories
import menu.data.State.coachNames
import menu.data.State.recommendedFoods

class OutputView {

    fun printRecommendation() {
        println(PRINT_RECOMMENDED_FOODS_RESULT)
        println(PRINT_RESULT_HEADER)
        println(PRINT_RESULT_CATEGORY.format(categories[0], categories[1], categories[2], categories[3], categories[4]))
        coachNames.forEach { coachName ->
            println(
                PRINT_RESULT_CONTENT.format(
                    coachName,
                    recommendedFoods[coachName]!![0],
                    recommendedFoods[coachName]!![1],
                    recommendedFoods[coachName]!![2],
                    recommendedFoods[coachName]!![3],
                    recommendedFoods[coachName]!![4]
                )
            )
        }
    }

    fun printError(errorType: Error) {
        when (errorType) {
            is Error.NameLengthError -> {
                println(errorType.message)
            }
        }
    }


    companion object {
        const val PRINT_RECOMMENDED_FOODS_RESULT = "메뉴 추천 결과입니다."
        const val PRINT_RESULT_HEADER = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"
        const val PRINT_RESULT_CATEGORY = "[ 카테고리 | %s | %s | %s | %s | %s ]"
        const val PRINT_RESULT_CONTENT = "[ %s | %s | %s | %s | %s | %s ]"
    }
}