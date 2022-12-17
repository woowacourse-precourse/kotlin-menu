package menu.domain

import menu.domain.model.FoodCategory
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName

class CategoryRecommandServiceTest {

    lateinit var categoryRecommandService: CategoryRecommandService

    @BeforeEach
    fun setup() {
        categoryRecommandService = CategoryRecommandService(CustomNumberGenerator())
    }

    @Test
    @DisplayName("추천 카테고리가 올바른 Enum클래스 반환하는지 테스트한다.")
    fun recommandCategoryTest() {
        assertThat(categoryRecommandService.recommandCategory() == FoodCategory.JAPANENSE)
        assertThat(categoryRecommandService.recommandCategory() == FoodCategory.KOREAN)
        assertThat(categoryRecommandService.recommandCategory() == FoodCategory.CHINESE)
        assertThat(categoryRecommandService.recommandCategory() == FoodCategory.ASIAN)
        assertThat(categoryRecommandService.recommandCategory() == FoodCategory.WESTERN)
    }

    inner class CustomNumberGenerator : GenerateNumber {
        private val categoryList = mutableListOf(1, 2, 3, 4, 5)

        override fun generate(): Int {
            return categoryList.removeAt(0)
        }

    }
}