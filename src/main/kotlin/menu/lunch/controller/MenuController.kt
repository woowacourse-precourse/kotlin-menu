package menu.lunch.controller

import menu.lunch.domain.MenuRecommend
import menu.lunch.domain.RandomCategory
import menu.lunch.view.InputView
import menu.lunch.view.OutputView

class MenuController {
    private val input by lazy { InputView() }
    private val output by lazy { OutputView() }
    private val category by lazy { RandomCategory() }
    private val recommend = MenuRecommend()

    fun run() {
        output.printStartMessage()
        addCoach()
        addDislikedFood()
        chooseMenu()
        output.printMenuRecommendResult(recommend.categoryRecord, recommend.coaches)
    }

    private fun addCoach() {
        recommend.addCoach(input.readNameOfCoaches())
    }

    private fun addDislikedFood() {
        recommend.coaches.forEach { coach ->
            recommend.addDislikedFood(coach.name, input.readDislikeMenu(coach.name))
        }
    }

    private fun chooseMenu() {
        while (recommend.categoryRecord.size < 5) {
            val category = category.getRandomCategory()
            if (recommend.isEatSameCategoryMany(category.category).not()) {
                recommend.addCategoryRecord(category)
            }
        }
    }
}
