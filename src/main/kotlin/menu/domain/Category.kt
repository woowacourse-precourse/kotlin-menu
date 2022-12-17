package menu.domain

import camp.nextstep.edu.missionutils.Randoms

enum class Category(private val number: Int) {
    JAPANESE(1),
    KOREAN(2),
    CHINESE(3),
    ASIAN(4),
    WESTERN(5);

    companion object {
        private const val ERROR_NOT_CATEGORY = "일치하는 카테고리가 없습니다."

        fun from(number: Int): Category {
            return Category.values()
                .firstOrNull { it.number == number }
                ?: throw IllegalArgumentException(ERROR_NOT_CATEGORY)
        }

        fun makeRandomCategory(): Category {
            val number = Randoms.pickNumberInRange(1, 5)
            return Category.from(number)
        }
    }
}