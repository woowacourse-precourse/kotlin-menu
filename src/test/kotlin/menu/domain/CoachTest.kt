package menu.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CoachTest {
    private lateinit var coach: Coach

    @BeforeEach
    fun set() {
        coach = Coach("토미", listOf("우동", "스시"))
    }

    @Test
    fun `먹을 수 없는 메뉴일 경우 테스트`() {
        assertThat(coach.canEatMenu("우동")).isFalse
    }

    @Test
    fun `이미 먹은 메뉴인 경우 테스트`() {
        coach.addMenu("비빔밥")
        assertThat(coach.isAlreadyHad("비빔밥")).isTrue
    }
}