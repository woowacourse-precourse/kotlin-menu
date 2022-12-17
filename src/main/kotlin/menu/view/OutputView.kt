package menu.view

import menu.domain.Category

class OutputView {

    fun printRecommendMenu(coaches: List<String>, recommendFood: MutableMap<String, MutableList<String>>) {
        coaches.forEach{
            print("[ $it ")
            recommendFood[it]?.forEach { menu ->
                print("| ")
                print(menu)
                print(" ")
            }
            println("]")
        }

    }
    fun printCategories(categories: List<Int>) {
        println(RESULT_RECOMMEND_MENU_MESSAGE)
        println(DAY_MESSAGE)
        print("[ 카테고리 ")
        categories.forEach{
            print("| ")
            print(Category.getNum(it)?.let { it1 -> Category.print(it1) })
            print(" ")
        }
        println("]")
    }

    fun printEnd(){
        println()
        println(MISSION_END)
    }
    companion object {
        const val RESULT_RECOMMEND_MENU_MESSAGE = "메뉴 추천 결과입니다."
        const val DAY_MESSAGE = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"
        const val MISSION_END = "추천을 완료했습니다."
    }
}