package menu

import menu.domain.use_case.ValidateCoachNameUseCase
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidateCoachNameUseCaseTest {

    val value = "아,우,원"
//    private val validateCoachNameUseCaseTest: ValidateCoachNameUseCase = ValidateCoachNameUseCase(notSeparatedCoachNames = value)

    @Test
    fun `코치 이름 길이가 2이상 4이하가 아니면 예외를 던진다`() {
        assertThrows<IllegalArgumentException> {
//            validateCoachNameUseCaseTest()
        }
    }
}