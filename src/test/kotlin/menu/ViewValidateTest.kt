package menu

import menu.view.ViewValidate
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ViewValidateTest {

    lateinit var viewValidate: ViewValidate

    @BeforeEach
    fun setup() {
        viewValidate = ViewValidate()
    }

    @ParameterizedTest
    @ValueSource(strings = ["토미,제임스릴러,포코주부", "토", "토미,제임,스릴,러포,코주,부자"])
    fun `코치들 이름 입력 형식 유효성 테스트`(input: String) {
        assertThrows<IllegalArgumentException> {
            viewValidate.coachNamesForm(input)
        }
    }
}