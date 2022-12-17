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

    @Nested
    inner class CoachBanMenuTest {
//        현재 메뉴에 없는 입력 들어가는 예외처리 처리안됨(추후 처리)
//        @Test
//        fun `메뉴에 없는 입력 들어갔을시`() {
//            assertThrows<IllegalArgumentException> { validator.getCoachMenuBan("열라뽕따이,팟타이", "포비") }
//        }

        @Test
        fun `메뉴2가지 이상일때`() {
            assertThrows<IllegalArgumentException> { validator.getCoachWithMenuBan("팟타이,그라탱,뇨끼", "포코") }
        }

        @Test
        fun `메뉴 아무 입력 없을때`() {
            assertThat(validator.getCoachWithMenuBan("", "포코")).isEqualTo(listOf("포코"))
        }

        @Test
        fun `정상 입력시`() {
            assertThat(validator.getCoachWithMenuBan("팟타이,뇨끼", "포코")).isEqualTo(listOf("포코", "팟타이", "뇨끼"))
        }
    }
}
