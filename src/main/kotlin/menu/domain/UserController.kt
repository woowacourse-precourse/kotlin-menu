package menu.domain

import menu.ui.InputView
import menu.ui.OutputView

class UserController {
    private val outputView = OutputView()
    private val inputView = InputView()
    private val randomCategoryGenerator = RandomCategoryGenerator()
    private var coachNameContainer = listOf<String>() // 용민,세훈
    private var noEatingContainer = mutableListOf<List<String>>() // [[마라], [민초, 오이]]

    fun programRun() {
        outputView.printInitNotice()
        outputView.printNoticeEnterName()
        coachNameContainer = inputView.enterCoachName()

        for (coachName in coachNameContainer.indices) {
            outputView.printNoticeNoEating(coachNameContainer[coachName])
            noEatingContainer.add(inputView.enterNoEating())
        }
        programResult(coachNameContainer)
    }

    private fun programResult(coachNameContainer: List<String>) {
        val categoryList = randomCategoryGenerator.createRandomCategory()
        outputView.printNoticeResult()
        outputView.printCategoryContainer(categoryList)
        for (coachName in coachNameContainer.indices) {
            val menuList = MenuCreator(categoryList).readCategory()
            outputView.printFoodContainer(menuList, coachNameContainer[coachName])
        }
        outputView.printFinishNotice()
    }
}