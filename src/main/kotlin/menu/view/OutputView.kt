package menu.view

class OutputView {

    fun printCoachMenu(result: MutableList<String>) {
        println(result.joinToString(" | ","[ "," ]"))
    }
    fun printRecommandComplete() {
        println("\n추천을 완료했습니다.")
    }
    fun printCantEat(name: String) {
        println("\n${name}(이)가 못 먹는 메뉴를 입력해 주세요.")
    }
    fun printStartRecommand() {
        println("점심 메뉴 추천을 시작합니다.\n")
        println("코치의 이름을 입력해 주세요. (, 로 구분)")
    }
    fun printRecommandResult(category: List<String>) {
        println("\n메뉴 추천 결과입니다.")
        val week: List<String> = listOf("구분","월요일","화요일","수요일","목요일","금요일")
        println(week.joinToString(" | ","[ "," ]"))
        println(category.joinToString(" | ","[ "," ]"))
    }

}