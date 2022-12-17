package menu

import menu.validation.InputValidation
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidationTest {
    private val inputValidation = InputValidation()

    @Test
    fun `입력값의 코치이름 개수 값이 2미만 5초과라면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            inputValidation.checkNumberOfCoach("구구,제임스,구구,제임스,구구,제임스")
        }
    }

    @Test
    fun `입력값의 코치이름 길이 값이 2미만 4초과라면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            inputValidation.checkCoachNameLength(listOf("제","제우스우스우"))
        }
    }

    @Test
    fun `입력값의 음식 수가 2를초과하면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            inputValidation.checkNumberOfImpossibleFood("계란말이,계란,개장")
        }
    }

    @Test
    fun `입력값의 음식이 메뉴에 포함되지 않을 시 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            inputValidation.checkInvalidImpossibleFood(listOf("개고기"))
        }
    }



}