package menu

import menu.exception.CoachNameException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CoachNameTest {
    @Test
    fun `코치 이름 길이가 2보다 작다`() {
        assertThrows<IllegalArgumentException> {
            CoachNameException("가나,나,다하")
        }
    }

    @Test
    fun `코치 이름 길이가 4보다 크다`() {
        assertThrows<IllegalArgumentException> {
            CoachNameException("가나,나나,다하마,다다다다,우왁진짜크다")
        }
    }

    @Test
    fun `입력된 코치가 최소 두 명이 아니다`() {
        assertThrows<IllegalArgumentException> {
            CoachNameException("가나")
        }
    }

    @Test
    fun `입력된 코치가 최대 다섯 명이 아니다`() {
        assertThrows<IllegalArgumentException> {
            CoachNameException("일일,이이,삼삼,사사,오오,육육")
        }
    }
}