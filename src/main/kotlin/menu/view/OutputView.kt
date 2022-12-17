package menu.view

import menu.model.Coach
import menu.values.Category
import menu.values.MenuMessage

class OutputView {
    fun printMessage(message: String) {
        println(message)
    }

    fun printMenu(weeklyCategory: List<Category>, coaches: List<Coach>) {
        println(MenuMessage.MENU_RESULT)
        println(MenuMessage.WEEKLY_DAY)
        printCategory(weeklyCategory)
        repeat(coaches.size) { index ->
            printOneDayMenu(coaches[index].name, coaches[index].weeklyMenus)
        }
        println(MenuMessage.END)
    }

    private fun printCategory(weeklyCategory: List<Category>) {
        print(MenuMessage.CATEGORY_MESSAGE)
        repeat(weeklyCategory.size) { index ->
            print(MenuMessage.CATEGORY_PRINT.format(weeklyCategory[index].koreanName))
        }
        println(MenuMessage.CLOSE_SQUARE_BRACKETS)
        println(MenuMessage.ENTER)
    }

    private fun printOneDayMenu(name: String, weeklyMenus: List<String>) {
        print(MenuMessage.COACH_NAME.format(name))
        repeat(weeklyMenus.size) { index ->
            print(MenuMessage.MENU_PRINT.format(weeklyMenus[index]))
        }
        println(MenuMessage.CLOSE_SQUARE_BRACKETS)
    }
}