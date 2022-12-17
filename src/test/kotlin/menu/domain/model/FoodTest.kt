package menu.domain.model

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class FoodTest {

    @Test
    @DisplayName("잘못된 음식이 입력 됬을 때 오류를 발생한다.")
    fun constructorTest() {
        assertThrows<IllegalArgumentException> {
            Food.of(
                "오징어게임"
            )
        }
    }
}
