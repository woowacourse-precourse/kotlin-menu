package menu

import menu.domain.Menus
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MenusTest {
    @Test
    fun `못 먹는 메뉴는 0개에서 2개 사이가 아닌 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Menus(listOf("짜장면", "짬뽕", "김밥"))
        }.printStackTrace()
    }
}