package menu.domain

import menu.view.InputView
import menu.view.OutputView
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MenuRecommendationTest {
    private lateinit var menuRecommendation: MenuRecommendation

    @BeforeEach
    fun set() {
        menuRecommendation = MenuRecommendation(InputView(), OutputView())
    }

    @Test
    fun `, 를 기준으로 구분된 요소 각각의 공백이 잘 제거되는지 테스트`() {
        val values = listOf(" 토미 ","   제임스", " 포코   ")
        val result = listOf("토미", "제임스", "포코")
        assertThat(menuRecommendation.removeTrims(values)).isEqualTo(result)
    }

}