package menu.domain

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CategoriesTest {

    @BeforeEach
    fun setCategories() {
        categories = Categories()
    }

    @Test
    fun `카테고리는 5개까지만 추가될 수 있다`() {
        assertThrows<IllegalStateException> {
            repeat(6) {
                categories.addRandomCategory()
            }
        }
    }

    companion object {
        private var categories = Categories()
    }
}