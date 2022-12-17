package menu

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MenuTest {
    class InputException() {
        @Test
        fun `코치 수가 범위에서 벗어날 경우`() {
            assertThrows<IllegalArgumentException> {
                val names = listOf("안희애", "가나", "다라", "마바", "사아", "자차")
                Validator().validateCoachName(names)
            }
        }

        @Test
        fun `코치 이름 수가 범위에서 벗어날 경우`() {
            assertThrows<IllegalArgumentException> {
                val names = listOf("안희애", "가")
                Validator().validateCoachName(names)
            }
        }

        @Test
        fun `못 먹는 음식이 2개를 넘는 경우`() {
            assertThrows<IllegalArgumentException> {
                val food = listOf("짬뽕", "김밥", "떡볶이")
                Validator().validateFood(food)
            }
        }

        @Test
        fun `메뉴에 음식이 존재하지 않을 경우`() {
            assertThrows<IllegalArgumentException> {
                val food = listOf("짬뽕", "김밥", "초콜렛")
                Validator().validateFood(food)
            }
        }
    }
}