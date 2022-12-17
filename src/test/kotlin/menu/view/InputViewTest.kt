package menu.view

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import menu.main
import menu.strings.ErrorMessage
import menu.strings.Message
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class InputViewTest : NsTest(){
    @ParameterizedTest
    @ValueSource(strings = ["q", "asdfasdf", "asdf,asdf,asdfasdf"])
    fun `입력 테스트1`(input: String){
        assertSimpleTest{
            runException(input)
            assertThat(output().contains(ErrorMessage.COACH_NUMBER))
        }
    }


    override fun runMain() {
        main()
    }
}