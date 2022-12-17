package menu

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
//    printStartRecommand()
//    var coachName = inputName()
//    var cantEatMenu = mutableMapOf<String, List<String>>()
//    coachName.forEachIndexed() { _, it ->
//        printCantEat(it)
//        cantEatMenu[it] = inputMenu()
//    }
//    menuRecommandService(cantEatMenu)
    println(createRandomCategory())
}
fun menuRecommandService(cantEatMenu: Map<String, List<String>>) {

}
fun createRandomCategory(): MutableList<String> {
    val categories: List<String> = listOf("","일식", "한식", "중식", "아시안", "양식")
    var result = mutableListOf<String>()
    var count = 0
    var category: String
    while(count != 5) {
        var randomNum = Randoms.pickNumberInRange(1, 5)
        if(randomNum == 0) {
            continue
        } else if(randomNum != 0) {
            category = categories.get(randomNum)
            result.add(count, category)
            count++
        }
    }
    return result
}
fun recommandMenu(category: String) {
    var menus: List<String> = when(category) {
        "일식" -> listOf("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")
        "한식" -> listOf("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")
        "중식" -> listOf("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")
        "아시안" -> listOf("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")
        "양식" -> listOf("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")
        else -> throw IllegalArgumentException()
    }
    val menu: String = Randoms.shuffle(menus)[0]
}
fun printStartRecommand() {
    println("점심 메뉴 추천을 시작합니다.")
    println("코치의 이름을 입력해 주세요. (, 로 구분)")
}
fun inputName(): List<String> {
    var name = Console.readLine()
    return name.split(",")
}
fun printCantEat(name: String) {
    println("${name}(이)가 못 먹는 메뉴를 입력해 주세요.")
}
fun inputMenu(): List<String> {
    var menu = Console.readLine()
    return menu.split(",")
}
fun printRecommandResult() {
    println("메뉴 추천 결과입니다.")
    println("추천을 완료했습니다.")
}