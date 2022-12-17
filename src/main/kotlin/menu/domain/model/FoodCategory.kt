package menu.domain.model

import camp.nextstep.edu.missionutils.Randoms
import menu.util.*
import java.lang.IllegalArgumentException

enum class FoodCategory(
    private val categoryName: String,
    private val menus: List<String>
) {
    KOREAN("한식", KOREAN_FOODS),
    JAPANENSE("일식", JAPANESE_FOODS),
    CHINESE("중식", CHINESE_FOODS),
    ASIAN("아시안", ASIAN_FOODS),
    WESTERN("양식", WESTERN_FOODS);

    fun recommand(): Food {
        return Food(this, Randoms.shuffle(menus)[0])
    }

    fun getCategoryName() = categoryName

    companion object {
        fun categoryOf(category: Int): FoodCategory {
            return when (category) {
                1 -> JAPANENSE
                2 -> KOREAN
                3 -> CHINESE
                4 -> ASIAN
                5 -> WESTERN
                else -> throw IllegalArgumentException("잘못된 카테고리 번호입니다.")
            }
        }

        fun categoryOfFoodName(foodName: String): FoodCategory {
            values().forEach {
                if (it.menus.contains(foodName)) {
                    return it
                }
            }
            throw IllegalArgumentException("그런 음식 이름은 존재하지 않습니다.")
        }
    }

}