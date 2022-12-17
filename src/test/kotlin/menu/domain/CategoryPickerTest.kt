package menu.domain

import menu.domain.AvaliableMenu.*
import menu.domain.categorynumbergenerator.StubCategotyNumberGenerator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CategoryPickerTest {

    @Test
    fun `함수 정상작동 테스트`() {
        val categoryPicker = CategoryPicker(StubCategotyNumberGenerator(mutableListOf(1, 2, 3, 4, 5)))
        Assertions.assertThat(categoryPicker.genrateCategorys()).isEqualTo(
            listOf(
                JAPAN,
                KOREA,
                CHINA,
                ASIA,
                EURO
            )
        )
    }

    @Test
    fun `함수 정상작동 테스트2`() {
        val categoryPicker = CategoryPicker(StubCategotyNumberGenerator(mutableListOf(1, 2, 2, 4, 5)))
        Assertions.assertThat(categoryPicker.genrateCategorys()).isEqualTo(
            listOf(
                JAPAN,
                KOREA,
                KOREA,
                ASIA,
                EURO
            )
        )
    }

    @Test
    fun `함수 정상작동 테스트3`() {
        val categoryPicker = CategoryPicker(StubCategotyNumberGenerator(mutableListOf(1, 2, 2, 2, 4, 5)))
        Assertions.assertThat(categoryPicker.genrateCategorys()).isEqualTo(
            listOf(
                JAPAN,
                KOREA,
                KOREA,
                ASIA,
                EURO
            )
        )
    }
}
