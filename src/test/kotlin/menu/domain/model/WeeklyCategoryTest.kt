package menu.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows

class WeeklyCategoryTest {


    @Test
    @DisplayName("음식 카테고리가 3개 이상의 중복이 있는지 테스트한다.")
    fun hasDuplicatedCategory() {
        val weeklyCategory = WeeklyCategory(
            listOf(
                Weekday.MONDAY(FoodCategory.ASIAN),
                Weekday.TUESDAY(FoodCategory.ASIAN),
                Weekday.WEDNESDAY(FoodCategory.ASIAN),
                Weekday.THURSDAY(FoodCategory.KOREAN),
                Weekday.FRIDAY(FoodCategory.KOREAN),
            )
        )
        assertThat(weeklyCategory.hasDuplicatedCategory()).isTrue
    }

    @Test
    @DisplayName("5일 초과의 요일이 입력되면 에러를 발생한다.")
    fun muchWeekDaysTest() {
        assertThrows<IllegalArgumentException> {
            WeeklyCategory(
                listOf(
                    Weekday.MONDAY(FoodCategory.ASIAN),
                    Weekday.TUESDAY(FoodCategory.ASIAN),
                    Weekday.WEDNESDAY(FoodCategory.JAPANENSE),
                    Weekday.WEDNESDAY(FoodCategory.JAPANENSE),
                    Weekday.THURSDAY(FoodCategory.KOREAN),
                    Weekday.FRIDAY(FoodCategory.KOREAN),
                )
            )
        }
    }

    @Test
    @DisplayName("동일한 2개의 요일이 입력되면 에러를 발생한다.")
    fun duplicatedWeekDaysTest() {
        assertThrows<IllegalArgumentException> {
            WeeklyCategory(
                listOf(
                    Weekday.MONDAY(FoodCategory.ASIAN),
                    Weekday.MONDAY(FoodCategory.ASIAN),
                    Weekday.WEDNESDAY(FoodCategory.JAPANENSE),
                    Weekday.THURSDAY(FoodCategory.KOREAN),
                    Weekday.FRIDAY(FoodCategory.KOREAN),
                )
            )
        }
    }
}