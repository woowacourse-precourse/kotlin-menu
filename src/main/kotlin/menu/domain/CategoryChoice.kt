package menu.domain

import camp.nextstep.edu.missionutils.Randoms
import menu.utils.Constant

class CategoryChoice {

    private val categories = mutableListOf<Category>(
        Category.JAPANESE_FOOD,
        Category.JAPANESE_FOOD,
        Category.ASIAN_FOOD,
        Category.CHINESE_FOOD,
        Category.WESTERN_FOOD,
        Category.KOREAN_FOOD
    )

    fun randomCategory(): MutableList<String> {
        val recommendationCategory = mutableListOf<String>()
        while (recommendationCategory.size != 6) {
            val category = categories.get(Randoms.pickNumberInRange(1, 5))
            recommendationCategory.add(category.name)
        }
        return recommendationCategory
    }

//    fun MutableList<String>.categoryDuplicateCheck(): Boolean {
//        this.forEach {
//            this.toString().replace(it,"")
//
//        }
//
//        println(this)
//        return this.count { it.count() > 2 } == 0
//    }
}