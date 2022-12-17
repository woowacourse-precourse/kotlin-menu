package menu.controller

import menu.domain.MenuRecommend
import menu.domain.RandomCategory
import menu.view.InputView
import menu.view.OutputView

class MenuController {
    private val input by lazy { InputView() }
    private val output by lazy { OutputView() }
    private val category by lazy { RandomCategory() }
    private val recommend by lazy { MenuRecommend() }

    fun run() {
        // catch
        try {
            output.printStartMessage()
            addCoach()
            addDislikedFood()
            chooseMenu()
            output.printMenuRecommendResult(recommend.logOfCategory, recommend.coaches)
        } catch (e: Exception) {
            println(e.message)
        }
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
        while (recommend.logOfCategory.size < 5) {
            val category = category.getRandomCategory()
            if (recommend.isEatSameCategoryMany(category.category).not()) {
                recommend.addCategoryRecord(category)
            }
        }
    }
}
