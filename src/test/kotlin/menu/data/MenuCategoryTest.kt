package menu.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class MenuCategoryTest {
    @ParameterizedTest
    @ValueSource(strings = ["규동", "쌈밥", "나시고렝"])
    fun `존재하는 메뉴인지 확인 테스트`(input: String) {
        assertThat(MenuCategory.isValidateMenu(input)).isTrue
    }

    @ParameterizedTest
    @ValueSource(strings = ["꿔바로우", "돈코츠라멘", "오징어불고기"])
    fun `존재하지 않는 메뉴인지 확인 테스트`(input: String) {
        assertThat(MenuCategory.isValidateMenu(input)).isFalse
    }
}