package menu

import camp.nextstep.edu.missionutils.Randoms

class Categories {
    private val categoryChosen = mutableListOf<Int>()

    fun chooseCategory(): Int {
        val randomNumber = Randoms.pickNumberInRange(0, Category.values().size)
        if (categoryChosen.count { it == randomNumber } == MAX_NUMBER_OF_DUPLICATE_CATEGORY) {
            chooseCategory()
        }
        categoryChosen.add(randomNumber)
        return randomNumber
    }

    companion object {
        private const val MAX_NUMBER_OF_DUPLICATE_CATEGORY = 2
    }
}