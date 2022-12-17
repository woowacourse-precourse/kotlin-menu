package menu

import menu.domain.Category
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test


class CategoryTest {
    @Test
    fun `수익률을 출력한다`() {
        val result = Category.getNum(1)
        Assertions.assertThat(result).isEqualTo(Category.JAPAN)
    }
}
