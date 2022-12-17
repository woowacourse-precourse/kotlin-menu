package menu.domain

import menu.data.Menu.ASIAN_CATEGORY
import menu.data.Menu.CHINESE_CATEGORY
import menu.data.Menu.JAPANESE_CATEGORY
import menu.data.Menu.KOREAN_CATEGORY
import menu.data.Menu.WESTERN_CATEGORY
import menu.data.State.categories
import java.lang.IllegalArgumentException

class CategoryMaker(private val categoryNumberGenerator: CategoryNumberGenerator) {

    fun makeCategory(): List<String> {
        do {
            val randomCategoryNumber = categoryNumberGenerator.generate()
            val randomCategoryString = transformCategoryNumberToString(randomCategoryNumber)
            if (categories.count { it == randomCategoryString } != 2) {
                categories.add(randomCategoryString)
            }
        } while (categories.size != 5)
        return categories.toList()
    }


    private fun transformCategoryNumberToString(number: Int): String {
        return when (number) {
            1 -> JAPANESE_CATEGORY
            2 -> KOREAN_CATEGORY
            3 -> CHINESE_CATEGORY
            4 -> ASIAN_CATEGORY
            5 -> WESTERN_CATEGORY
            else -> throw IllegalArgumentException()
        }
    }

}