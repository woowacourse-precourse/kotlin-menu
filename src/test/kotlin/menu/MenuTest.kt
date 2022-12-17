package menu

import menu.data.Category
import menu.model.MenuRecommender
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MenuTest {
    private val menuRecommender = MenuRecommender()

    @Test
    fun `한 주에 카테고리가 2번 초과 중복되는지 테스트`() {
        val categories = menuRecommender.generateWeekCategory()
        for (category in Category.values()) assertThat(categories.filter { it == category }).hasSizeLessThanOrEqualTo(2)
    }
}