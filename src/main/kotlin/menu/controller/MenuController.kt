package menu.controller

import menu.domain.RandomCategoryGenerator
import menu.model.Flag
import menu.model.Recommender
import menu.view.InputView
import menu.view.OutputView

class MenuController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val categoryGenerator = RandomCategoryGenerator()
    private val result = mutableListOf<List<String>>()
    private var day: Int = 1

    fun recommendMenu() {
        val recommender = init()
        var categoryNumber: Int
        while (day <= 5) {
            do {
                categoryNumber = categoryGenerator.generate() - 1
                val flag = recommender.selectCategory(categoryNumber)
            } while (flag == Flag.FAIL)
            val todayCategory = recommender.getCategory(categoryNumber)
            val menuList = recommender.selectMenu(todayCategory)
            result.add(menuList)
            day++
        }
        outputView.printResult(recommender, result)
    }

    private fun init(): Recommender {
        outputView.printStart()
        val coachNames = inputView.readCoachName()
        val banFood = mutableListOf<List<String>>()
        for (name in coachNames) {
            banFood.add(inputView.readFoodBan(name))
        }
        return Recommender(coachNames, banFood)
    }
}