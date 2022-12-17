package menu.view

import menu.values.REQUIRE_COACH_CANT_EAT_MENUS_MESSAGE_FORMAT

class OutputView {

    fun printMessage(message: String) {
        println(message)
    }

    fun printRequireCoachCantEatMenus(coachName: String) {
        println(REQUIRE_COACH_CANT_EAT_MENUS_MESSAGE_FORMAT.format(coachName))
    }

    fun printList(list: List<String>) {
        println(list.joinToString(" | ", "[ ", " ]"))
    }

    fun printErrorMessage(e: IllegalArgumentException) {
        println(e.message)
    }

}