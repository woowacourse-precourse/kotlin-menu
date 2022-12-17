package menu.domain.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CoachTest {

    @ParameterizedTest
    @ValueSource(strings = ["아", "가나다라마"])
    @DisplayName("코치 이름이 2글자 미만 4글자 초과면 에러가 발생한다.")
    fun nameLengthTest(name: String) {
        assertThrows<IllegalArgumentException> {
            Coach(name)
        }
    }

    @Test
    @DisplayName("못 먹는 음식을 3개 이상 넣으면 에러가 발생한다.")
    fun inedibleCountTest() {
        assertThrows<IllegalArgumentException> {
            Coach("팔코").apply {
                addInedible(Food.of("감차찌개"))
                addInedible(Food.of("짜장면"))
                addInedible(Food.of("된장찌개"))
            }
        }
    }

    @Test
    @DisplayName("못 먹는 음식을 중복으로 넣으면 에러가 발생한다.")
    fun inedibleDuplicatedTest() {
        assertThrows<IllegalArgumentException> {
            Coach("팔코").apply {
                addInedible(Food.of("감차찌개"))
                addInedible(Food.of("감차찌개"))
            }
        }
    }
}