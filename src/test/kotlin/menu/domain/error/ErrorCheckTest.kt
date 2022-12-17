package menu.domain.error

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ErrorCheckTest {

    @Test
    fun `입력받은 코치가 1명일 때 오류 발생`() {
        assertThrows<IllegalArgumentException> {
            ErrorCheck.checkNumberOfName(listOf("토미"))
        }
    }

    @Test
    fun `코치 이름이 범위를 벗어날 때 오류 발생`() {
        assertThrows<IllegalArgumentException> {
            ErrorCheck.checkLengthOfName("토미제임스포코")
        }
    }
}