package menu.controller

import camp.nextstep.edu.missionutils.Randoms
import menu.INSERT_NAME
import menu.START_MESSAGE
import menu.view.InputView
import menu.view.OutputView

class MenuController {

    fun start() {
        val names = startMenuRecommend()
        val cannotEatFood = askCannotEatFood(names)
        val category = randomCategory()

    }

    private fun startMenuRecommend(): List<String> {
        OutputView().printMessage(START_MESSAGE)
        OutputView().printMessage(INSERT_NAME)
        return InputView().readNames()
    }

    private fun askCannotEatFood(names: List<String>): MutableList<List<String>> {
        val cannotEatFood = mutableListOf<List<String>>()
        for (name in names) {
            OutputView().printCanNotEat(name)
            cannotEatFood.add(InputView().readCannotEat())
        }
        return cannotEatFood
    }

    fun randomCategory(): List<String> {
        val determinedCategory = mutableListOf<String>()
        val categories = listOf("일식", "한식", "중식", "아시안", "양식")
        while (determinedCategory.size < 5) {
            val category: String = categories[Randoms.pickNumberInRange(0, 4)]
            if (isContainedOver2(determinedCategory, category))
                continue
            determinedCategory.add(category)
        }
        return determinedCategory
    }

    private fun isContainedOver2(determinedCategory: MutableList<String>, category: String): Boolean {
        var count = 0
        for (determinedOne in determinedCategory) {
            if (determinedOne == category)
                count++
        }
        if (count > 2)
            return true
        return false
    }
}