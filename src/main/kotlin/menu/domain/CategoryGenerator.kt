package menu.domain

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange


class CategoryGenerator() {
    fun makeCategory(): MutableList<Int> {
        val category = mutableListOf<Int>()

        while (category.size < 5){
            val randomNumber = pickNumberInRange(1, 5)
            if (category.count() { it == randomNumber} <= 2) category.add(randomNumber)

        }
        println(category)
        return category
    }
}