package menu.exceptions

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ExceptionsTest {
    private val exceptions = Exceptions()

    @Test
    fun `코치 이름 중복 확인 테스트`() {
        assertThrows<IllegalArgumentException>{
            exceptions.validateCoachNames("포비,제임스,제임스")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["포비,제임스,최예린최고", "포비,제임스,짱"])
    fun `코치 이름 길이 확인 테스트`(input: String) {
        assertThrows<IllegalArgumentException>{
            exceptions.validateCoachNames(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["포비,제임스,예린,링링,재경,우테코", "포비"])
    fun `코치 인원 수 확인 테스트`(input: String) {
        assertThrows<IllegalArgumentException>{
            exceptions.validateCoachNames(input)
        }
    }

    @Test
    fun `음식 이름 중복 확인 테스트`() {
        assertThrows<IllegalArgumentException>{
            exceptions.validateCoachBias("우동,스시,우동")
        }
    }

    @Test
    fun `음식 갯수 길이 확인 테스트`() {
        assertThrows<IllegalArgumentException>{
            exceptions.validateCoachBias("우동,스시,뇨끼")
        }
    }

    @Test
    fun `존재하는 음식인지 확인 테스트`() {
        assertThrows<IllegalArgumentException>{
            exceptions.validateCoachBias("꿔바로우,우동")
        }
    }
}