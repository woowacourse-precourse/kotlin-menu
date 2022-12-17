package menu

import menu.view.InputValidator
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidatorTest {

    private val inputValidator = InputValidator()

    @ValueSource(strings = ["토미","토미,제이스,포코,",",토미,제이스,포코", "토미,제이스,포코,제임스,하이,사랑"])
    @ParameterizedTest
    fun `코치 입력 테스트`(input: String) {
        assertThrows<IllegalArgumentException> {
            inputValidator.validateCoach(input)
        }
    }

    @ValueSource(strings = ["우동,스시,팟타이","우동,우동"])
    @ParameterizedTest
    fun `메뉴 입력 테스트`(input: String) {
        assertThrows<IllegalArgumentException> {
            inputValidator.validateHateMenu(input)
        }
    }
}