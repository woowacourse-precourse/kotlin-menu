package menu

import menu.controller.CategoryController
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MenuTest {
    @Test
    fun `메뉴 중복 테스트`() {
        val determinedCategory = mutableListOf(Food.한식,Food.중식,Food.양식,Food.양식,Food.아시안)
        val category = Food.양식
        Assertions.assertTrue(CategoryController().isContainedOver2(determinedCategory,category))

//        assertThrows<IllegalArgumentException> {
//            Validator().validateBridgeSize("a")
//        }
    }
}