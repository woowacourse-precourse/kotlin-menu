package menu

private const val START_MSG="점심 메뉴 추천을 시작합니다."
private const val RESULT_MSG="메뉴 추천 결과입니다."
private const val DAY_OF_WEEK="[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"
private const val COMPLETE_MSG="추천을 완료했습니다."
class OutputView {

    fun printStart() {
        println(START_MSG)
    }

    fun printResult(category: List<String>, coachs: List<Coach>) {
        println(RESULT_MSG)
        println(DAY_OF_WEEK)
        printCategory(category)
        printCoach(coachs)
        println(COMPLETE_MSG)
    }

    private fun printCategory(category: List<String>) {
        println("[ 카테고리 | " + category.joinToString(" | ") + " ]")
    }

    private fun printCoach(coachs: List<Coach>) {
        for (coach in coachs) {
            println("[ ${coach.name} | ${coach.foodToEat.joinToString(" | ")} ]")
        }
    }

}