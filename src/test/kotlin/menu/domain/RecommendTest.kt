package menu.domain

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

internal class RecommendTest {

    private val recommend = Recommend()

    @Test
    fun recommendMenu() {
        val coach = Coach("혜경")
        coach.setCantEatMenus(listOf("김밥", "김치찌개"))
        for (i in 0 until 10) {
            val result = recommend.recommendMenu(coach, "한식")
            assertThat(listOf("김밥", "김치찌개")).doesNotContain(result)
        }
    }

    @Test
    fun recommendCategory() {
        for (i in 0 until 10) {
            val result = recommend.recommendCategory(listOf("한식", "한식", "양식"))
            assertThat(result).isNotEqualTo("한식")
        }
    }
}
