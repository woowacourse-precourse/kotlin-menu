package menu.domain

import camp.nextstep.edu.missionutils.Randoms
import menu.*

enum class Category(private val number: Int, private val text: String) {
    JAPANESE(1, JAPANESE_TEXT),
    KOREAN(2, KOREAN_TEXT),
    CHINESE(3, CHINESE_TEXT),
    ASIAN(4, ASIAN_TEXT),
    WESTERN(5, WESTERN_TEXT);

    override fun toString(): String {
        return text
    }

    companion object {
        private const val ERROR_NOT_CATEGORY = "%s 일치하는 카테고리가 없습니다."

        fun from(number: Int): Category {
            return Category.values()
                .firstOrNull { it.number == number }
                ?: throw IllegalArgumentException(ERROR_NOT_CATEGORY)
        }

        fun from(text: String): Category {
            return Category.values()
                .firstOrNull { it.text == text }
                ?: throw IllegalArgumentException(ERROR_NOT_CATEGORY.format(text))
        }

        fun makeRandomCategory(): Category {
            val number = Randoms.pickNumberInRange(1, 5)
            return Category.from(number)
        }
    }
}