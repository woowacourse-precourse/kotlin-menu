package menu

import menu.util.Validator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidTest {

    @Test
    fun `이름이 한글로 이루어지지 않은 경우`() {
        assertThrows<IllegalArgumentException> {
            Validator().checkNameValid("1하,")
        }
    }
}