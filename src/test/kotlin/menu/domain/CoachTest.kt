package menu.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CoachTest {
    @Test
    fun `코치의 이름이 최소 2글자, 최대 4글자가 아닌 경우`() {
        assertThrows<IllegalArgumentException> {
            Coach("구", listOf("김밥"))
        }
    }

    @Test
    fun `못 먹는 메뉴가 중복되는 경우`() {
        assertThrows<IllegalArgumentException> {
            Coach("구구", listOf("김밥", "김밥"))
        }
    }

    @Test
    fun `못 먹는 메뉴 수가 0개 이상 2개 이하가 아닌 경우`() {
        assertThrows<IllegalArgumentException> {
            Coach("구구", listOf("김밥", "김치찌개", "떡볶이"))
        }
    }

    @Test
    fun `존재하지 않는 메뉴가 포함되어 있는 경우`() {
        assertThrows<IllegalArgumentException> {
            Coach("구구", listOf("김"))
        }
    }
}