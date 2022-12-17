package menu

import menu.domain.Category
import menu.domain.CategoryChoice
import menu.domain.Recommendation
import menu.view.InputView
import menu.view.OutputView
import java.awt.Menu

class MenuController {
    fun run() {
        OutputView().menuRecommendationStartPrint()
        OutputView().coachNamePrint()
        val coachName = InputView().getCoachName()
        val coachUneatableMenu = mutableListOf<List<String>>()
        coachName.forEach {
            coachUneatableMenu.add(InputView().getCoachUneatableMenu(it))
        }
        val randomCategory = CategoryChoice().randomCategory()
        menuRecommendationStart(coachName, randomCategory, coachUneatableMenu)
    }

    fun menuRecommendationStart(
        coachName: List<String>,
        randomCategory: MutableList<Category>,
        coachUneatableMenu: MutableList<List<String>>
    ) {
        OutputView().menuRecommendationResultPrint()
        OutputView().menuRecommendationResultFirstPrint()
        OutputView().menuRecommendationResultCategoryPrint(randomCategory)

        for (i in coachName.indices) {
            val recommendationMenu = mutableListOf<String>(coachName[i])
            for (j in 0 until 5) {
                recommendationMenu.add(Recommendation().menuRecommendation(randomCategory[j], coachUneatableMenu[i], recommendationMenu))
            }
            OutputView().menuRecommendationResultMenuPrint(recommendationMenu)
        }
        OutputView().menuRecommendationEPrint()
    }
}