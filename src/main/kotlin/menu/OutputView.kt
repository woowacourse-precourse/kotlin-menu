package menu

class OutputView {
    fun print(string: String) {
        println(string)
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