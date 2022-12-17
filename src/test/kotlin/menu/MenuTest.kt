package menu

import menu.controller.CategoryController
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class MenuTest {
    @Test
    fun `메뉴`() {
        val determinedCategory = mutableListOf(Food.한식,Food.중식,Food.양식,Food.양식,Food.아시안)
        val category = Food.양식
        Assertions.assertTrue(CategoryController().isContainedOver2(determinedCategory,category))
    }
}