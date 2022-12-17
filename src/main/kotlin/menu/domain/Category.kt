package menu.domain

import camp.nextstep.edu.missionutils.Randoms
import menu.*

enum class Category(private val number: Int, private val text: String) {
    JAPANESE(JAPANESE_NUMBER, JAPANESE_TEXT),
    KOREAN(KOREAN_NUMBER, KOREAN_TEXT),
    CHINESE(CHINESE_NUMBER, CHINESE_TEXT),
    ASIAN(ASIAN_NUMBER, ASIAN_TEXT),
    WESTERN(WESTERN_NUMBER, WESTERN_TEXT);

    override fun toString(): String {
        return text
    }

    companion object {
        private const val ERROR_NOT_CATEGORY = "%s 일치하는 카테고리가 없습니다."
        fun from(text: String): Category {
            return Category.values()
                .firstOrNull { it.text == text }
                ?: throw IllegalArgumentException(ERROR_NOT_CATEGORY.format(text))
        }

        fun makeRandomCategory(): Category {
            val number = Randoms.pickNumberInRange(JAPANESE_NUMBER, WESTERN_NUMBER)
            return Category.from(number)
        }

        private fun from(number: Int): Category {
            return Category.values()
                .firstOrNull { it.number == number }
                ?: throw IllegalArgumentException(ERROR_NOT_CATEGORY)
        }
    }
}