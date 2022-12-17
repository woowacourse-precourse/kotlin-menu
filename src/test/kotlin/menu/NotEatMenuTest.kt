package menu

import menu.exception.NotEatMenuException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NotEatMenuTest {
    @Test
    fun `존재하는 메뉴인가`() {
        assertThrows<IllegalArgumentException> {
            NotEatMenuException("치킨")
        }
    }

    @Test
    fun `메뉴의 개수가 2개 초과인가`() {
        assertThrows<IllegalArgumentException> {
            NotEatMenuException("짬뽕, 김밥, 비빔밥")
        }
    }
}