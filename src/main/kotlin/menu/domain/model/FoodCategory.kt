package menu.domain.model

import camp.nextstep.edu.missionutils.Randoms
import menu.util.*
import menu.util.ERROR.NOT_EXIST_FOOD
import menu.util.ERROR.WROGN_CATEGORY_NUMBER
import java.lang.IllegalArgumentException

enum class FoodCategory(
    private val categoryName: String,
    private val menus: List<String>
) {
    KOREAN(KR_KOREAN, KOREAN_FOODS),
    JAPANENSE(KR_JAPANESE, JAPANESE_FOODS),
    CHINESE(KR_CHINESE, CHINESE_FOODS),
    ASIAN(KR_ASIAN, ASIAN_FOODS),
    WESTERN(KR_WESTERN, WESTERN_FOODS);

    fun recommand(): Food {
        return Food(this, Randoms.shuffle(menus)[ZERO])
    }

    fun getCategoryName() = categoryName

    companion object {

        const val JAPANESE_NUMBER = 1
        const val KOREAN_NUMBER = 2
        const val CHINESE_NUMBER = 3
        const val ASIAN_NUMBER = 4
        const val WESTERN_NUMBER = 5

        fun categoryOf(category: Int): FoodCategory {
            return when (category) {
                JAPANESE_NUMBER -> JAPANENSE
                KOREAN_NUMBER -> KOREAN
                CHINESE_NUMBER -> CHINESE
                ASIAN_NUMBER -> ASIAN
                WESTERN_NUMBER -> WESTERN
                else -> throw IllegalArgumentException(WROGN_CATEGORY_NUMBER)
            }
        }

        fun categoryOfFoodName(foodName: String): FoodCategory {
            values().forEach { category ->
                if (category.menus.contains(foodName)) {
                    return category
                }
            }
            throw IllegalArgumentException(NOT_EXIST_FOOD)
        }
    }

}