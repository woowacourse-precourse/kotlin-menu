package menu.controller

import menu.domain.RandomCategoryGenerator
import menu.model.Recommender
import menu.view.InputView
import menu.view.OutputView

class MenuController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val categoryGenerator = RandomCategoryGenerator()

    fun init(): Recommender {
        val coachNames = inputView.readCoachName()
        val banFood = mutableListOf<List<String>>()
        for (name in coachNames) {
            banFood.add(inputView.readFoodBan(name))
        }
        return Recommender(coachNames, banFood)
    }
}