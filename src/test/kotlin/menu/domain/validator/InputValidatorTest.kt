package menu.domain.validator

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidatorTest {

    val validator = InputValidator()

    @Nested
    inner class CoachNameTest {
        @Test
        fun `코치수 2미만 일때`() {
            assertThrows<IllegalArgumentException> { validator.getValidateCoachNames("포코") }
        }

        @Test
        fun `코치수 5초과 일때`() {
            assertThrows<IllegalArgumentException> { validator.getValidateCoachNames("포코,조던,월드피스,박남춘,장인성,말리빈") }
        }

        @Test
        fun `코치이름 크기 2미만일떄 일때`() {
            assertThrows<IllegalArgumentException> { validator.getValidateCoachNames("포코,조던,메,박남춘,장인성") }
        }

        @Test
        fun `코치이름 크기 4초과일떄 일때`() {
            assertThrows<IllegalArgumentException> { validator.getValidateCoachNames("포코,조던,메타월드피스,박남춘,장인성,말리빈") }
        }

        @Test
        fun `공백처리 확인 테스트`() {
            assertThrows<IllegalArgumentException> { validator.getValidateCoachNames("포코,조던,   ,박남춘,장인성,말리빈") }
        }
    }
}
