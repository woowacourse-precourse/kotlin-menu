package menu.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MenuRecommendTest {
    @Test
    fun `사용자 생성 확인`() {
        val menuRecommend = MenuRecommend()
        menuRecommend.addCoach(listOf("코치1", "코치2", "코치3"))
        menuRecommend.coaches.forEach { coach ->
            assertThat(coach.name in listOf("코치1", "코치2", "코치3")).isTrue()
        }
    }

    @Test
    fun `사용자가 먹지 않는 음식을 잘 거른다`() {
        val menuRecommend = MenuRecommend()
        menuRecommend.addCoach(listOf("코치1", "코치2", "코치3"))
        menuRecommend.addDislikedFood("코치1", listOf("김밥", "김치찌개"))
        menuRecommend.addDislikedFood("코치2", listOf("김밥", "김치찌개"))
        menuRecommend.addDislikedFood("코치3", listOf("김밥", "김치찌개"))
        repeat(4) {
            menuRecommend.addCategoryRecord(FoodCategory.values().first { it.category == "한식" })
            menuRecommend.coaches.forEach { coach ->
                assertThat("김밥" in coach.alreadyEatFood).isFalse
                assertThat("김치찌개" in coach.alreadyEatFood).isFalse
            }
        }
    }

    @Test
    fun `두개 이상 같은 음식을 먹었는지 확인한다`() {
        val menuRecommend = MenuRecommend()
        menuRecommend.addCoach(listOf("코치1", "코치2", "코치3"))
        menuRecommend.addDislikedFood("코치1", listOf("김밥", "김치찌개"))
        menuRecommend.addDislikedFood("코치2", listOf("김밥", "김치찌개"))
        menuRecommend.addDislikedFood("코치3", listOf("김밥", "김치찌개"))
        repeat(4) {
            menuRecommend.addCategoryRecord(FoodCategory.values().first { it.category == "한식" })
        }
        assertThat(menuRecommend.isEatSameCategoryMany("한식")).isTrue
    }
}
