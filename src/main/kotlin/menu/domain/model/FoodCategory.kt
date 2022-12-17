package menu.domain.model

import camp.nextstep.edu.missionutils.Randoms
import menu.util.*
import java.lang.IllegalArgumentException

enum class FoodCategory(private val menus: List<String>) {
    KOREAN(KOREAN_FOODS),
    JAPANENSE(JAPANESE_FOODS),
    CHINESE(CHINESE_FOODS),
    ASIAN(ASIAN_FOODS),
    WESTERN(WESTERN_FOODS);

    fun recommand(): String {
        return Randoms.shuffle(menus)[0]
    }

    fun containsFood(foodName: String): Boolean {
        return menus.contains(foodName)
    }

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