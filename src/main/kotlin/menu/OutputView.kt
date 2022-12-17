package menu

class OutputView {

    fun printStart() {
        println("점심 메뉴 추천을 시작합니다.")
    }

    fun printResult(category: List<String>, coachs: List<Coach>) {
        println("메뉴 추천 결과입니다.")
        println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]")
        printCategory(category)
        printCoach(coachs)
        println("추천을 완료했습니다.")
    }

    fun printCategory(category: List<String>) {
        println("[ 카테고리 | " + category.joinToString(" | ") + " ]")
    }

    fun printCoach(coachs: List<Coach>) {
        for (coach in coachs) {
            println("[ ${coach.name} |  ${coach.foodList.joinToString(" | ")}  ]")
        }
    }

//[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]
}