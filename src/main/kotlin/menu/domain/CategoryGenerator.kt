package menu.domain

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import menu.resource.MAX_DUPLE
import menu.resource.MAX_RANGE_FOOD_KIND
import menu.resource.MIN_RANGE_FOOD_KIND


class CategoryGenerator() {
    fun makeCategory(): MutableList<Int> {
        val category = mutableListOf<Int>()

        while (category.size < MAX_RANGE_FOOD_KIND){
            val randomNumber = pickNumberInRange(MIN_RANGE_FOOD_KIND, MAX_RANGE_FOOD_KIND)
            if (category.count() { it == randomNumber} <= MAX_DUPLE) category.add(randomNumber)
        }
        return category
    }
}