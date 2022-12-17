package menu.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class CategoryTest {

    @Test
    fun `카테고리를 이름으로 생성할 수 있다`() {
        val input = "한식"
        val expect = Category.KOREAN
        assertEquals(Category.from(input), expect)
    }

    @Test
    fun `1부터 5사이의 임의의 숫자로 카테고리를 생성할 수 있다`() {
        assertDoesNotThrow {
            Category.makeRandomCategory()
        }
    }
}