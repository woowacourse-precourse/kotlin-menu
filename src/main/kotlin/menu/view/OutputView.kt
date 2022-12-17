package menu.view

import menu.domain.Category
import menu.utils.Constant.COACH_NAME_MESSAGE
import menu.utils.Constant.COACH_UNEATABLE_MENU_MESSAGE
import menu.utils.Constant.MENU_RECOMMENDATION_END_MESSAGE
import menu.utils.Constant.MENU_RECOMMENDATION_RESULT_CATEGORY_MESSAGE
import menu.utils.Constant.MENU_RECOMMENDATION_RESULT_FIRST_MESSAGE
import menu.utils.Constant.MENU_RECOMMENDATION_RESULT_MENU_MESSAGE
import menu.utils.Constant.MENU_RECOMMENDATION_RESULT_MESSAGE
import menu.utils.Constant.MENU_RECOMMENDATION_START_MESSAGE

class OutputView {
    fun menuRecommendationStartPrint() = println(MENU_RECOMMENDATION_START_MESSAGE)
    fun coachNamePrint() = println(COACH_NAME_MESSAGE)
    fun coachUneatableMenuPrint(name: String) = println(COACH_UNEATABLE_MENU_MESSAGE.format(name))

    fun menuRecommendationResultPrint() = println(MENU_RECOMMENDATION_RESULT_MESSAGE)

    fun menuRecommendationResultFirstPrint() = println(MENU_RECOMMENDATION_RESULT_FIRST_MESSAGE)
    fun menuRecommendationResultCategoryPrint(category: List<Category>) = println(
        MENU_RECOMMENDATION_RESULT_CATEGORY_MESSAGE.format(
            category[0].foodName,
            category[1].foodName,
            category[2].foodName,
            category[3].foodName,
            category[4].foodName
        )
    )

    fun menuRecommendationResultMenuPrint(menu: List<String>) = println(
        MENU_RECOMMENDATION_RESULT_MENU_MESSAGE.format(
            menu[0],
            menu[1],
            menu[2],
            menu[3],
            menu[4],
            menu[5]
        )
    )
    fun menuRecommendationEPrint() = println(MENU_RECOMMENDATION_END_MESSAGE)


}