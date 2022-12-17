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

    for (coachIndex in coaches.indices) {  //코치마다 요일별로 메뉴 추천
        val coachMenu = mutableListOf<String>()
        for (categoryIndex in recommendedCategory.indices) {
            val menu = menuRecommend.pickMenu(recommendedCategory[categoryIndex], coachMenu, dislikeMenus[coachIndex])
            coachMenu.add(menu)
        }
        recommendedMenu.add(coachMenu)
    }
}

fun printRecommendCategory(categories: List<String>){
    println("[ 카테고리 | ${categories[0]} | ${categories[1]} | ${categories[2]} | ${categories[3]} | ${categories[4]} ]")
}

fun printRecommendMenu(menus: List<List<String>>, coaches: List<String>) {
    for (coachIndex in coaches.indices){
        val coachMenu = menus[coachIndex]
        println("[ ${coaches[coachIndex]} | ${coachMenu[0]} | ${coachMenu[1]} | ${coachMenu[2]} | ${coachMenu[3]} | ${coachMenu[4]} ]")
    }
}
