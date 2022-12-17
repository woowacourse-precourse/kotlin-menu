package menu.domain

import menu.resources.ASIAN_FOOD_CATEGORY
import menu.resources.CHINESE_FOOD_CATEGORY
import menu.resources.JAPANESE_FOOD_CATEGORY
import menu.resources.KOREAN_FOOD_CATEGORY
import menu.resources.WESTERN_FOOD_CATEGORY
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RandomCategoryTest {
    // test random category
    @Test
    fun `랜덤 카테고리를 잘 반환한다`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest({
            val randomCategory = RandomCategory()
            Assertions.assertThat(randomCategory.getRandomCategory().category).isEqualTo(JAPANESE_FOOD_CATEGORY)
            Assertions.assertThat(randomCategory.getRandomCategory().category).isEqualTo(KOREAN_FOOD_CATEGORY)
            Assertions.assertThat(randomCategory.getRandomCategory().category).isEqualTo(CHINESE_FOOD_CATEGORY)
            Assertions.assertThat(randomCategory.getRandomCategory().category).isEqualTo(ASIAN_FOOD_CATEGORY)
            Assertions.assertThat(randomCategory.getRandomCategory().category).isEqualTo(WESTERN_FOOD_CATEGORY)
        }, 1, 2, 3, 4, 5)
    }
}
