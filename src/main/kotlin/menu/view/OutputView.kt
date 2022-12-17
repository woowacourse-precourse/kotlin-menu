package menu.view

import menu.model.Category
import menu.model.Coach
import menu.model.Menu
import menu.data.Message

class OutputView {
    fun print(string: String, vararg args: Pair<String, String>) {
        var msg = string
        for (arg in args)
            msg = msg.replace(arg.first, arg.second)
        println(msg)
    }

    fun printRecommendationResult(categories: List<Category>, menusByCoaches: Map<Coach, List<Menu>>) {
        print(Message.MSG_MENU_RESULT)
        print(Message.MSG_WEEK)
        print("[ 카테고리 | ${categories.joinToString(" | ")} ]")
        for ((coach, menus) in menusByCoaches) {
            print("[ ${coach.getName()} | ${menus.joinToString(" | ")} ]")
        }
        print("")
        print(Message.MSG_END)
    }
}