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

    @Test
    fun `같은 카테고리를 세 번 이상 포함하지 않는지 검사`() {
        val suggestionMenu = SuggestionMenu()
        val category = mutableListOf<Category>(Category.JAPANESE_FOOD,
            Category.KOREAN_FOOD,
            Category.CHINESE_FOOD,
            Category.ASIAN_FOOD,
            Category.WESTERN_FOOD,
            Category.JAPANESE_FOOD,
            Category.CHINESE_FOOD,
            Category.ASIAN_FOOD,
            Category.WESTERN_FOOD)
        val result = suggestionMenu.suggestionCategory(category)
        val expected = Category.KOREAN_FOOD // 마지막에는 결국 두번이상 나오지 않은 한국음식을 추천해줘야 함.
        assertThat(result).isEqualTo(expected)
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

    private fun SuggestionMenu.suggestionCategory(choiceCategory: List<Category>): Category {
        val randomCategory = Randoms.pickNumberInRange(SuggestionMenu.LOW_CATEGORY, SuggestionMenu.HIGH_CATEGORY)
        val category = FindCategoryByValue.fromValue(randomCategory)
        var count = 0
        choiceCategory.forEach { // 중복 카테고리는 최대 두 개만 허용한다.
            if (category == it) count++
        }
        return if (count >= 2)
            suggestionCategory(choiceCategory)
        else
            return category!!
    }
}