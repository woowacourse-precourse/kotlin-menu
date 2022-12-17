package menu

import camp.nextstep.edu.missionutils.Randoms
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SuggestionMenuTest {

    @Test
    fun `싫어하는 음식 없이 포함하지 않고 추천해줬는지 검사`() {
        val suggestionMenu = SuggestionMenu()
        val coach = Coach("포비",
            mutableListOf<String>("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "오코노미야끼"), mutableListOf())
        suggestionMenu.suggestionEachMenu(FindCategoryByValue.fromValue(1)!!, coach)
        val expected = mutableListOf<String>("라멘")
        assertThat(coach.menus).isEqualTo(expected) // 포비 코치님은 라멘 빼고 일식 다 싫어하므로 라멘이 나와야 함.
    }

    private fun SuggestionMenu.suggestionEachMenu(choiceCategory: Category, coach: Coach) {
        while (true) {
            val menu: String = Randoms.shuffle(this.getAllMenus()[choiceCategory.index])[0]
            if (coach.menus.find { it == menu } != null || menu in coach.hateEatMenus) {
                continue
            }
            coach.menus.add(menu)
            break
        }
    }
}