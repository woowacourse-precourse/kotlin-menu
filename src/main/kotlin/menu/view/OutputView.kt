package menu.view

import menu.domain.Category

class OutputView {

    fun printStart() {
        println(START_RECOMMEND)
    }

    fun printResult(category: List<Category>, menus: Map<String, List<String>>) {
        println(RESULT_RECOMMEND)
        printLine(TITLE_DAYS, days)
        printLine(TITLE_CATEGORY, category)
        for (menu in menus.keys) {
            printLine(menu, menus[menu]!!)
        }
        println(END_RECOMMEND)
    }

    private fun <T> printLine(name: String, value: List<T>) {
        print(MENU_START)
        print("$name$MENU_SEPARATOR")
        print(value.joinToString(MENU_SEPARATOR))
        println(MENU_END)
    }

    companion object {
        const val START_RECOMMEND = "점심 메뉴 추천을 시작합니다."
        const val RESULT_RECOMMEND = "\n메뉴 추천 결과입니다."
        const val END_RECOMMEND = "\n추천을 완료했습니다."

        const val MENU_START = "["
        const val MENU_END = "]"
        const val MENU_SEPARATOR = " | "

        const val TITLE_DAYS = "구분"
        const val TITLE_CATEGORY = "카테고리"
        val days = listOf("월요일", "화요일", "수요일", "목요일", "금요일")
    }
}