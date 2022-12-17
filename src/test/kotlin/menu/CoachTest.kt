package menu

import camp.nextstep.edu.missionutils.test.NsTest
import menu.data.Coach
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CoachTest: NsTest() {

    @Test
    fun isUneatableTrueTest() {
        val coach = Coach("제임스")
        coach.addUneatableMenus(listOf("떡볶이"))
        coach.addUneatableMenus(listOf("우동"))
        coach.addUneatableMenus(listOf("짜장면"))
        assertThat(coach.isUneatable("짜장면")).isEqualTo(true)
    }

    @Test
    fun isUneatableFalseTest() {
        val coach = Coach("제임스")
        coach.addUneatableMenus(listOf("떡볶이"))
        coach.addUneatableMenus(listOf("우동"))
        coach.addUneatableMenus(listOf("짜장면"))
        assertThat(coach.isUneatable("쌈밥")).isEqualTo(false)
    }

    @Test
    fun addUneatableMenusTest() {
        val coach = Coach("제임스")
        coach.addUneatableMenus(listOf("떡볶이"))
        assertThat(coach.isUneatable("떡볶이"))
    }

    override fun runMain() {
        main()
    }
}