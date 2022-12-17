package menu.view

import menu.utils.Constant

class OutputView {
    fun menuRecommendationStartPrint() = println(Constant.MENU_RECOMMENDATION_START_MESSAGE)
    fun coachNamePrint() = println(Constant.COACH_NAME_MESSAGE)
    fun coachUneatableMenuPrint() = println()
}