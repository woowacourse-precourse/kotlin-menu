package menu.view

import menu.utils.Constant
import menu.utils.Constant.COACH_NAME_MESSAGE
import menu.utils.Constant.COACH_UNEATABLE_MENU_MESSAGE
import menu.utils.Constant.MENU_RECOMMENDATION_START_MESSAGE

class OutputView {
    fun menuRecommendationStartPrint() = println(MENU_RECOMMENDATION_START_MESSAGE)
    fun coachNamePrint() = println(COACH_NAME_MESSAGE)
    fun coachUneatableMenuPrint(name: String) = println(COACH_UNEATABLE_MENU_MESSAGE.format(name))
}