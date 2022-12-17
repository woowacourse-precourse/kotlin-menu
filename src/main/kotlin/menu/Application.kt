package menu

import menu.UI.InputView
import menu.UI.OutputView

fun main() {
    //시작문구
    OutputView().serviceStart()

    //코치 생성
    var coachNames = InputView().coachName()
    var coach = mutableListOf<Coach>()
    for (i in coachNames){
        var person = Coach()
        person.setName(i)
        coach.add(person)
    }

    //코치 싫어하는 음식
    for (i in coach){
        var hateFoods = InputView().hateFood(i)
        i.hateFood = hateFoods.toMutableList()
    }

    //추천할 카테고리 정하기
    var category = Category()
    var weekCategory = category.recommandCategory()
    println(weekCategory)

    //코치 메뉴 추천
    for(i in coach){
        var coachMenu = category.coachMenu(i, weekCategory)
        i.menu = coachMenu
        println(i.menu)
    }

    //메뉴 추천표 출력
    OutputView().menuResult(coach, weekCategory)
}
