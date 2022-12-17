package menu

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val recommender = MenuRecommender()

    println("점심 메뉴 추천을 시작합니다.")
    println()
    val coaches = inputView.readCoaches()
    println()
    inputView.readMenus(coaches)
    val result = recommender.makeMenus(coaches)
    outputView.printResult(result)
}
