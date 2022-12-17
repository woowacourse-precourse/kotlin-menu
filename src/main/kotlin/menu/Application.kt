package menu

import menu.UI.InputView
import menu.UI.OutputView

fun main() {
    //시작문구
    OutputView().serviceStart()

    //코치 생성
    var coachNames = InputView().coachName()
    var coaches = mutableListOf<Coach>()
    for (i in coachNames){
        var person = Coach()
        person.setName(i)
        coaches.add(person)
    }

    //코치 싫어하는 음식
    for (i in coaches){
        var hateFoods = InputView().hateFood(i)
        i.hateFood = hateFoods.toMutableList()
    }

    //추천할 카테고리 정하기
    var category = Category()
    var weekCategory = category.recommandCategory()

    //코치 메뉴 추천
    for (i in weekCategory){
        if (i =="일식") coaches = category.coachJapanMenu(coaches)
        if (i == "한식") coaches = category.coachKoreaMenu(coaches)
        if (i == "중식") coaches = category.coachChinaMenu(coaches)
        if (i == "아시안") coaches = category.coachAsianMenu(coaches)
        if (i == "양식") coaches = category.coachWestMenu(coaches)
    }

    /*for(i in coach){
        var coachMenu = category.coachMenu(i, weekCategory)
        i.menu = coachMenu
    }*/

    //메뉴 추천표 출력
    OutputView().menuResult(coaches, weekCategory)

    //종료 메시지
    OutputView().serviceEnd()
}
