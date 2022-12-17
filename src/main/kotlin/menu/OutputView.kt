package menu

class OutputView {
    fun printStartMessage() {
        println("점심 메뉴 추천을 시작합니다.\n")
    }

    fun printMenuRecommendation(recommendation: MutableMap<String, MutableList<String>>, coaches: List<String>) {
        println(RECOMMENDATION_RESULT)
        println(DAYS_OF_A_WEEK)
        println(CATEGORY)
        coaches.forEach { name ->
            val toPrint = mutableListOf<String>(name)
            recommendation[name]?.forEach { menu ->
                toPrint.add(menu)
            }
            println(toPrint.joinToString(prefix = "[ ", separator = " | ", postfix = " ]"))
        }
    }

    fun printEndMessage() {

    }

    companion object {
        private const val RECOMMENDATION_RESULT = "메뉴 추천 결과입니다."
        private const val DAYS_OF_A_WEEK = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"
        private const val CATEGORY = "[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]"
    }
}