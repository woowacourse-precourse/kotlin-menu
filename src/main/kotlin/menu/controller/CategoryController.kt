package menu.controller

import camp.nextstep.edu.missionutils.Randoms
import menu.data.Categories

class CategoryController {
    private val recommendCategories= mutableListOf<String>()

    init {
        setRecommendCategory()
    }

    fun getRecommendCategory(): List<String> = recommendCategories

    private fun setRecommendCategory() {
        for(day in 0 until 5) {
            var category = getCategory()

            while(true) {
                if(recommendCategories.count{ it == category } < 2) {
                    break
                }
                category = getCategory()
            }
            recommendCategories.add(category)
        }
    }

    private fun getCategory(): String {
        return Categories.categories[Randoms.pickNumberInRange(1, 5) - 1]
    }
}