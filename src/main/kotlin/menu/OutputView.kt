package menu

class OutputView {
    fun printStart() {
        println("점심 메뉴 추천을 시작합니다.")
    }

    fun printResult(category: List<String>, recommendations: Map<String, List<String>>) {
        println("메뉴 추천 결과입니다.")
        println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]")
        println("[ 카테고리 | ${category[0]} | ${category[1]} | ${category[2]} | ${category[3]} | ${category[4]} ]")
        for(recommendation in recommendations) {
            val menus = recommendation.value
            println("[ ${recommendation.key} | ${recommendation.value[0]} | ${recommendation.value[1]} | ${recommendation.value[2]} | ${recommendation.value[3]} | ${recommendation.value[4]} ]")
        }

        println("추천을 완료했습니다.")
    }
}