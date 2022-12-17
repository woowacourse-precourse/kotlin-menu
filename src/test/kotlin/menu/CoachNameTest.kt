package menu

import menu.domain.CoachName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CoachNameTest {
    @ParameterizedTest
    @ValueSource(strings = ["", "밥", "하나둘셋넷"])
    fun `코치 이름을 잘못 입력한 경우 예외가 발생한다`(value: String) {
        assertThrows<IllegalArgumentException> {
            CoachName(value)
        }
    }
}