package menu.domain.use_case

import camp.nextstep.edu.missionutils.Randoms
import menu.data.Menu
import menu.data.Menu.ASIAN_CATEGORY
import menu.data.Menu.CHINESE_CATEGORY
import menu.data.Menu.JAPANESE_CATEGORY
import menu.data.Menu.KOREAN_CATEGORY
import menu.data.Menu.WESTERN_CATEGORY
import menu.data.Menu.asianFoods
import menu.data.Menu.chineseFoods
import menu.data.Menu.japaneseFoods
import menu.data.Menu.koreanFoods
import menu.data.Menu.westernFoods
import menu.data.State.categories
import menu.data.State.coachNames
import menu.data.State.recommendedFoods
import menu.ui.Views

class RecommendFoodsUseCase(
    private val views: Views = Views(),
) {
    operator fun invoke() {

        initRecommendedFoods()

        saveRecommendFoods()

//        println(recommendedFoods)
        views.outputView.printRecommendation()
    }

    private fun initRecommendedFoods() {
        coachNames.forEach { coachName ->
            recommendedFoods[coachName] = arrayListOf()
        }
    }

    private fun saveRecommendFoods() {
        coachNames.forEach { coachName ->
            categories.forEach { category ->
                val recommendedFood = Randoms.shuffle(transformCategoryStringToMenus(category))[0]
                recommendedFoods[coachName]!!.add(recommendedFood)
            }
        }
    }

    private fun transformCategoryStringToMenus(category: String): List<String> {
        return when (category) {
            JAPANESE_CATEGORY -> japaneseFoods
            KOREAN_CATEGORY -> koreanFoods
            CHINESE_CATEGORY -> chineseFoods
            ASIAN_CATEGORY -> asianFoods
            WESTERN_CATEGORY -> westernFoods
            else -> throw IllegalArgumentException()
        }
    }


}