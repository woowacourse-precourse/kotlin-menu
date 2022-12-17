package menu

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.test.NsTest
import menu.data.Coach
import menu.maker.MenuRecommender
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.mockito.Mockito
import java.time.Duration
import java.util.*

class MenuRecommenderTest : NsTest() {

    @Test
    fun makeManusTest() {
        val coaches = listOf(Coach("민지"), Coach("해린"), Coach("하니"), Coach("혜인"), Coach("다니엘"))
        val recommender = MenuRecommender()
        coaches[0].addUneatableMenus(listOf("김치찌개","우동"))
        coaches[1].addUneatableMenus(listOf("깐풍기","나시고렝"))
        coaches[2].addUneatableMenus(listOf("파인애플 볶음밥","카오 팟"))
        coaches[3].addUneatableMenus(listOf("마파두부","우동"))
        coaches[4].addUneatableMenus(listOf("김치찌개","오니기리"))
        val menuResult = recommender.makeMenus(coaches)
        var judgeResult = true
        for (category in menuResult.categories) {
            val count = menuResult.categories.count { it == category }
            if (count > 2) judgeResult = false
        }
        for (coach in coaches) {
            for (menu in menuResult.recommendations[coach.name]!!) {
                if (coach.isUneatable(menu)) judgeResult = false
            }
        }
        assertThat(judgeResult).isTrue
    }

    override fun runMain() {
        main()
    }

    companion object {
        private val RANDOM_TEST_TIMEOUT = Duration.ofSeconds(10L)
        private fun assertRandomTest(
                executable: Executable,
                vararg mockingValues: ApplicationTest.Mocking<*>
        ) {
            Assertions.assertTimeoutPreemptively(RANDOM_TEST_TIMEOUT) {
                Mockito.mockStatic(Randoms::class.java).use { mock ->
                    Arrays.stream(mockingValues).forEach { mocking -> mocking.stub(mock) }
                    executable.execute()
                }
            }
        }
    }
}