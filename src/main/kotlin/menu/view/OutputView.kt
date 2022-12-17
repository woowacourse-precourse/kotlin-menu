package menu.view

class OutputView {

    fun printServiceStart() {
        println(SERVICE_START_MESSAGE)
    }

    fun printServiceEnd() {
        print(SERVICE_END_MESSAGE)
    }

    fun printMenuResultInitialMessage() {
        println(MENU_RESULT_INITIAL_MESSAGE)
    }

    fun printDayOfTheWeekMessage() {
        println(DAY_OF_THE_WEEK_MESSAGE)
    }

    fun printCategories(categories: List<String>) {
        print("$SENTENCE_START $CATEGORY ")
        categories.forEach { category ->
            print("$DIVIDE_LINE $category ")
        }
        println(SENTENCE_END)
    }

    fun printMenus(coachName: String, menus: List<String>) {
        print("$SENTENCE_START $coachName ")
        menus.forEach { menu ->
            print("$DIVIDE_LINE $menu ")
        }
        println(SENTENCE_END)
    }

    companion object {
        const val SERVICE_START_MESSAGE = "점심 메뉴 추천을 시작합니다."
        const val SERVICE_END_MESSAGE = "추천을 완료했습니다."
        const val MENU_RESULT_INITIAL_MESSAGE = "메뉴 추천 결과입니다."
        const val DAY_OF_THE_WEEK_MESSAGE = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"
        const val CATEGORY = "카테고리"
        const val SENTENCE_START = "["
        const val SENTENCE_END = "]"
        const val DIVIDE_LINE = "|"
    }
}