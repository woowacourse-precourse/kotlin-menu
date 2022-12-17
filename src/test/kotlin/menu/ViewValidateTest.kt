package menu

import menu.view.ViewValidate
import org.junit.jupiter.api.BeforeEach

class ViewValidateTest {

    lateinit var viewValidate: ViewValidate

    @BeforeEach
    fun setup() {
        viewValidate = ViewValidate()
    }
}