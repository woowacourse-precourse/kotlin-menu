package menu

fun main() {
    val input = InputView()

    val dislikeMenus = mutableListOf<List<String>>()

    println("점심 메뉴 추천을 시작합니다.")
    val coaches = input.getCoachNames()

    for (coachIndex in coaches.indices) {
        val coachName = coaches[coachIndex]
        val dislike = input.getDislikeMenu(coachName)
        dislikeMenus.add(dislike)
    }
}
