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
        showMenu(categoryList)
        outputView.printFinishNotice()
    }

    private fun showMenu(categoryList: MutableList<String>) {
        for (coachName in coachNameContainer.indices) {
            val menuList = MenuCreator(categoryList).createRandomMenu()
            if (checkMenu(menuList, coachName)) {
                outputView.printFoodContainer(menuList, coachNameContainer[coachName])
            } else showMenu(categoryList)
        }
    }

    private fun checkMenu(menuList: MutableList<String>, coachName: Int): Boolean {
        for (food in 0 until noEatingContainer[coachName].size - 1) {
            if (menuList.contains(noEatingContainer[coachName][food]))
                return false
        }
        return true
    }

}