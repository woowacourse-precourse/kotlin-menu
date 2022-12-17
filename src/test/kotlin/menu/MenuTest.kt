package menu

import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import camp.nextstep.edu.missionutils.test.Assertions
import org.assertj.core.api.Assertions.assertThat

class MenuTest : NsTest(){
    @Test
    fun `코치 이름이 1글자 이하 일 때`(){
        Assertions.assertSimpleTest{
            runException("윤","뚜비")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }
    @Test
    fun `코치 이름이 5글자 이상 일 때`(){
        Assertions.assertSimpleTest{
            runException("우아한형제","뚜비")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }
    @Test
    fun `입력된 코치가 1명 이하일 때`(){
        Assertions.assertSimpleTest{
            runException("포비")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }
    @Test
    fun `입력된 코치가 이름이 6명 이상일 때`(){
        Assertions.assertSimpleTest{
            runException("포비","뽀로로","루피","크롱","해리","에디")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}