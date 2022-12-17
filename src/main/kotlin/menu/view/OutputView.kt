package menu.view

import menu.model.Coach
import menu.values.Category
import menu.values.GameMessage

class OutputView {
    fun printMessage(message:String){
        println(message)
    }

    fun printMenu(weeklyCategory:List<Category>,coaches:List<Coach>){
        println("메뉴 추천 결과입니다.")
        println(GameMessage.WEEKLY_DAY)
        printCategory(weeklyCategory)
        repeat(coaches.size){index->
            printOneDayMenu(coaches[index].name,coaches[index].weeklyMenus)
        }
        println("추천을 완료했습니다.")
    }

    private fun printCategory(weeklyCategory:List<Category>){
        print("[ 카테고리 ")
        repeat(weeklyCategory.size){index->
            print(GameMessage.CATEGORY_PRINT.format(weeklyCategory[index].koreanName))
        }
        println("]")
    }
    private fun printOneDayMenu(name:String,weeklyMenus:List<String>){
        print("[ $name ")
        repeat(weeklyMenus.size) {index->
            print(GameMessage.MENU_PRINT.format(weeklyMenus[index]))
        }
        println("]")
    }
}