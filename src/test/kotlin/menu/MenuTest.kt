package menu

import menu.data.Category
import menu.data.Coach
import menu.data.Menu
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

    private fun generateRecommendation(): Map<Coach, List<Menu>> {
        return menuRecommender.getRecommendation(
            listOf(Category.ASIAN, Category.ASIAN, Category.JAPANESE, Category.JAPANESE, Category.KOREAN), listOf(
                Coach("coach1", listOf(Menu("규동"), Menu("김밥"))),
                Coach("coach2", listOf())
            )
        )
    }

    @Test
    fun `코치가 못 먹는 메뉴가 추천됐는지 테스트`() {
        val menusByCoaches = generateRecommendation()
        for ((coach, menus) in menusByCoaches)
            for (menu in menus)
                assertThat(coach.validateMenu(menu)).isFalse()
    }

    @Test
    fun `한 코치가 같은 메뉴를 먹는지 테스트`() {
        val menusByCoaches = generateRecommendation()
        for ((_, menus) in menusByCoaches)
            for (menu in menus)
                assertThat(menus.count { it == menu }).isEqualTo(1)
    }
}