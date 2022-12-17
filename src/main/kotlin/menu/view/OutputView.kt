package menu.view

import menu.utils.DAYS
import menu.utils.OUTPUT_MENU_RESULT

object OutputView {

    fun printResult(
        weekend: MutableMap<String, String>,
        coachMenus: MutableMap<String, MutableList<String>>
    ) {
        println(OUTPUT_MENU_RESULT)
        println(printDays())
        printCategory(weekend)
        printMenus(coachMenus)
    }

    private fun printDays() {
        val days = DAYS.split(", ")
        println("[ " + days.joinToString(" | ") + " ]")
    }

    private fun printCategory(weekend: MutableMap<String, String>) {
        println("[ 카테고리 | " + weekend.values.joinToString(" | ") + " ]")
    }

    private fun printMenus(coachMenus: MutableMap<String, MutableList<String>>) {
        coachMenus.entries.map { menus ->
            println("[ ${menus.key} | " + menus.value.joinToString(" | ") + " ]")
        }
        println()
        println("추천을 완료했습니다.")
    }
}