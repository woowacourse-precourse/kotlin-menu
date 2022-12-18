package menu

import menu.model.Category
import menu.model.Menu
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class MenuTest {

    @ParameterizedTest
    @CsvSource(
        "중식,짜장면",
        "일식,규동",
        "아시안,쌀국수",
        "한식,김밥",
        "양식,스파게티"
    )
    fun `카테고리별 메뉴 추천 기능 테스트`(category:String,menu:String){
        assertThat(Menu().getCategoryMenu(category)).contains(menu)
    }

}