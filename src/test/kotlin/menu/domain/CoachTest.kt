package menu.domain

import menu.resources.KOREAN_FOOD_MENU
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CoachTest {
    @Test
    fun `코치가 못 먹는 음식을 잘 거른다`() {
        val coach = Coach("코치1")
        coach.addDislikedFood("김밥")
        coach.addDislikedFood("김치찌개")

        repeat(KOREAN_FOOD_MENU.size - 2) {
            coach.eatFood(FoodCategory.values().first { it.category == "한식" })
            assertThat("김밥" in coach.alreadyEatFood).isFalse()
            assertThat("김치찌개" in coach.alreadyEatFood).isFalse()
        }
    }

    @Test
    fun `코치가 이미 먹은 음식은 거른다`() {
        val coach = Coach("코치1")
        val temp = mutableListOf<String>()
        repeat(KOREAN_FOOD_MENU.size) {
            coach.eatFood(FoodCategory.values().first { it.category == "한식" })
            assertThat(coach.alreadyEatFood[coach.alreadyEatFood.lastIndex] !in temp).isTrue
            temp.add(coach.alreadyEatFood[coach.alreadyEatFood.lastIndex])
        }
    }

    @Test
    fun `이름이 같은지 확인한다`() {
        val coach = Coach("코치1")
        assert(coach.isName("코치1"))
    }
}
