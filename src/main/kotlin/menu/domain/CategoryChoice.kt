package menu.domain

import camp.nextstep.edu.missionutils.Randoms
import menu.utils.Constant

class CategoryChoice {

    private val categories = mutableListOf<Category>(
        Category.JAPANESE_FOOD,
        Category.JAPANESE_FOOD,
        Category.KOREAN_FOOD,
        Category.CHINESE_FOOD,
        Category.ASIAN_FOOD,
        Category.WESTERN_FOOD,
    )

    fun randomCategory(): MutableList<Category> {
        val recommendationCategory = mutableListOf<Category>()
        while (recommendationCategory.size != 6) {
            if (recommendationCategory.categoryDuplicateCheck()) {
                val category = categories.get(Randoms.pickNumberInRange(1, 5))
                recommendationCategory.add(category)
            }
        }
        return recommendationCategory
    }

    fun MutableList<Category>.categoryDuplicateCheck(): Boolean {
        this.forEach {
            return this.count { cnt ->
                it == cnt
            } <= 2
        }
        return true
    }
}