package menu.view

class OutputView {

    fun printStart() = println("점심 메뉴 추천을 시작합니다")

    fun printInputCoachNames() = println("코치의 이름을 입력해 주세요. (, 로 구분)")

    fun printInputExcludedFood(name: String) = println("$name(이)가 못 먹는 메뉴를 입력해 주세요.")
}