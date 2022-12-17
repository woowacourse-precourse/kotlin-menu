package menu.UI

import menu.Coach

class OutputView {
    fun serviceStart(){
        println("점심 메뉴 추천을 시작합니다.")
    }

    fun menuResult(coach: MutableList<Coach>, weekCategory: MutableList<String>){
        println("메뉴 추천 결과입니다.\n" +
                "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]\n" +
                "[ 카테고리 | ${weekCategory[0]} | ${weekCategory[1]} | ${weekCategory[2]} | ${weekCategory[3]} | ${weekCategory[4]} ]")
        for (i in coach){
            println( "[ ${i.getName()} | ${i.menu[0]} | ${i.menu[1]} | ${i.menu[2]} | ${i.menu[3]} | ${i.menu[4]} ]")
        }
    }

    fun serviceEnd(){
        println("추천을 완료했습니다.")
    }
}