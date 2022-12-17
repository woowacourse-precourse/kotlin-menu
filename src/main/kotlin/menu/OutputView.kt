package menu

import menu.CategoryAndMenu.categories

class OutputView {

    fun printThisWeekCategories(categoryNumbers: List<Int>) {
        println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]")
        print("[ 카테고리 ")
        categoryNumbers.forEach { categoryNum ->
            print("| ${categories[categoryNum]} ")
        }
        print("]\n")
    }

    fun printCoachMenus(coach: Coach) {
        print("[ ${coach.name} ")
        coach.thisWeekMenus.forEach { eachMenu ->
            print("| $eachMenu ")
        }
        print("]\n")
    }

    fun printResultRecommendation(){
        println("메뉴 추천 결과입니다.")
    }

    fun printGameEnd(){
        println("추천을 완료했습니다.")
    }
}