package menu.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class FoodCategoryTest {

    @Test
    @DisplayName("음식명과 카테고리가 매칭되는지 테스트한다.")
    fun categoryOfFoodNameTest() {
        assertThat(FoodCategory.categoryOfFoodName("김치찌개")).isEqualTo(FoodCategory.KOREAN)
        assertThat(FoodCategory.categoryOfFoodName("규동")).isEqualTo(FoodCategory.JAPANENSE)
        assertThat(FoodCategory.categoryOfFoodName("깐풍기")).isEqualTo(FoodCategory.CHINESE)
        assertThat(FoodCategory.categoryOfFoodName("팟타이")).isEqualTo(FoodCategory.ASIAN)
        assertThat(FoodCategory.categoryOfFoodName("뇨끼")).isEqualTo(FoodCategory.WESTERN)
    }

}