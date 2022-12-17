package menu.controller

import camp.nextstep.edu.missionutils.Randoms
import menu.Food

class CategoryController {
    fun randomCategory(): List<Food> {
        val determinedCategory = mutableListOf<Food>()
        while (determinedCategory.size < 5) {
            val randomCategory = chooseRandomCategory()
            if (isContainedOver2(determinedCategory, randomCategory))
                continue
            determinedCategory.add(randomCategory)
        }
        return determinedCategory
    }

    private fun chooseRandomCategory(): Food {
        val categories = listOf(Food.일식, Food.한식, Food.중식, Food.아시안, Food.양식)
        return categories[Randoms.pickNumberInRange(1, 5) - 1]
    }

    private fun isContainedOver2(determinedCategory: MutableList<Food>, category: Food): Boolean {
        var count = 0
        for (determinedOne in determinedCategory) {
            if (determinedOne == category)
                count++
        }
        if (count >= 2)
            return true
        return false
    }
}