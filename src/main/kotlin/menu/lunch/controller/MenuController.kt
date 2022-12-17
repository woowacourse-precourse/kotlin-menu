package menu.lunch.controller

import menu.lunch.domain.MenuRecommend
import menu.lunch.domain.RandomCategory
import menu.lunch.view.InputView
import menu.lunch.view.OutputView

class MenuController {
    private val input by lazy { InputView() }
    private val recommend = MenuRecommend()

    fun run() {
        addCoach()
    }

    private fun addCoach() {
        recommend.addCoach(input.readNameOfCoaches())
    }
}
