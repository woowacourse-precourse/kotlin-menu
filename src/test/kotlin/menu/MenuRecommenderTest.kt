package menu

import menu.model.Coach
import menu.model.DayOfWeek
import menu.model.Menu
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class MenuRecommenderTest {

    @Nested
    inner class `recommendMenus 메소드는` {

        @Nested
        inner class `코치들이 주어지면` {

            @Test
            fun `추천되는 메뉴의 카테고리는 최대 2개까지 중복된다`() {
                val coaches = createCoaches()

                MenuRecommender.recommendMenus(coaches)

                assertThat(coaches).allMatch { coach ->
                    coach.recommendedCategories()
                        .all { category -> coach.recommendedCategories().count { it == category } <= 2 }
                }
            }

            @Test
            fun `모든 코치들에게 추천된 메뉴는 중복되지 않는다`() {
                val coaches = createCoaches()

                MenuRecommender.recommendMenus(coaches)

                assertThat(coaches).allMatch { coach ->
                    val recommendedMenus = DayOfWeek.values().map { day -> coach.getRecommendedMenu(day) }
                    recommendedMenus.size == recommendedMenus.toSet().size
                }
            }

            @Test
            fun `모든 코치들에게 월화수목금요일 모두 메뉴가 추천된다`() {
                val coaches = createCoaches()

                MenuRecommender.recommendMenus(coaches)

                DayOfWeek.values().forEach { day ->
                    assertThatCode { coaches.forEach { coach -> coach.getRecommendedMenu(day) } }.doesNotThrowAnyException()
                }
            }

            private fun createCoaches(): List<Coach> {
                val tomi = Coach("토미")
                val james = Coach("제임스")
                val poco = Coach("포코")

                tomi.setCantEatMenus(listOf(Menu("우동"), Menu("스시")))
                james.setCantEatMenus(listOf(Menu("뇨끼"), Menu("월남쌈")))
                poco.setCantEatMenus(listOf(Menu("마파두부"), Menu("고추잡채")))

                return listOf(tomi, james, poco)
            }
        }
    }
}