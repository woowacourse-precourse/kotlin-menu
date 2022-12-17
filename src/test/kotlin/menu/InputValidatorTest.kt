package menu

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import menu.view.InputValidator
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

private const val DUPLICATED_ERROR = "중복된 값이 있습니다."
private const val NAME_ERROR = "코치들은 2~5명이어야합니다."
private const val MENU_COUNT_ERROR = "못 먹는 메뉴는 0~2개여야합니다."

class InputValidatorTest {
    private val inputValidator = InputValidator()

    @Test
    fun `이름 중복 테스트`() {
        val names = listOf<String>("용민", "용민")
        assertSimpleTest {
            assertThatThrownBy {
                inputValidator.validateNames(names)
            }.isExactlyInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining(DUPLICATED_ERROR)
        }
    }

    @Test
    fun `이름 개수 테스트`() {
        val names = listOf<String>("용민")
        assertSimpleTest {
            assertThatThrownBy {
                inputValidator.validateNames(names)
            }.isExactlyInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining(NAME_ERROR)
        }
    }

    @Test
    fun `메뉴 중복 테스트`() {
        val menus = listOf<String>("뇨끼", "뇨끼")
        assertSimpleTest {
            assertThatThrownBy {
                inputValidator.validateMenus(menus)
            }.isExactlyInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining(DUPLICATED_ERROR)
        }
    }

    @Test
    fun `메뉴 개수 테스트`() {
        val menus = listOf<String>("뇨끼", "라자냐", "프렌치 토스트")
        assertSimpleTest {
            assertThatThrownBy {
                inputValidator.validateMenus(menus)
            }.isExactlyInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining(MENU_COUNT_ERROR)
        }
    }
}
