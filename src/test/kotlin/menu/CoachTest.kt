package menu

import menu.domain.Coach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CoachTest {
    @Test
    fun `코치가 2명에서 5명 사이가 아닌 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Coach(listOf("첫째", "둘째", "셋째", "넷째", "다섯째", "여섯째"))
        }
    }
}