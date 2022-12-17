package menu.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CoachTest {

    @ValueSource(strings = ["코코", "제임스", "테스트", "하이", "HI"])
    @ParameterizedTest
    fun `코치 이름으로 생성할 수 있다`(name: String) {
        assertDoesNotThrow {
            println(name.length)
            Coach(name)
        }
    }

    @ValueSource(strings = ["코", "제임스다다다", "테스트해봐", "하이하우왈유", "HIIMTESTS"])
    @ParameterizedTest
    fun `코치 이름 길이는 2이상 4이하 이다`(name: String) {
        assertThrows<IllegalArgumentException> {
            Coach(name)
        }
    }

    @Test
    fun `못 먹는 메뉴가 2개가 넘어가면 예외를 발생시킨다`() {
        val inputs = listOf(
            Menu("김밥", Category.KOREAN),
            Menu("비빔밥", Category.KOREAN),
            Menu("칼국수", Category.KOREAN),
            Menu("불고기", Category.KOREAN)
        )
        val coach = Coach("테스트")
        assertThrows<IllegalArgumentException> {
            inputs.forEach {
                coach.addHateMenu(it)
            }
        }
    }
}