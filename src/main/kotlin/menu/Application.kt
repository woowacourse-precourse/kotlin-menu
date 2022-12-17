package menu

fun main() {
    val input = InputView()
    val menuRecommend = MenuRecommend()

    val dislikeMenus = mutableListOf<List<String>>()
    val recommendedCategory = mutableListOf<String>()
    val recommendedMenu = mutableListOf<List<String>>()

    println("점심 메뉴 추천을 시작합니다.")
    val coaches = input.getCoachNames()

    for (coachIndex in coaches.indices) {
        val coachName = coaches[coachIndex]
        val dislike = input.getDislikeMenu(coachName)
        dislikeMenus.add(dislike)
    }

    for(date in 0..4){ //요일별로 추천해줄 메뉴 카테고리 선정
        val todayCategory = menuRecommend.pickCategory(recommendedCategory)
        recommendedCategory.add(todayCategory)
    }
}
