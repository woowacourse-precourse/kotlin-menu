package menu.controller

import menu.domain.CategoryRecommandService
import menu.domain.GenerateRandomNumbers
import menu.domain.model.*
import menu.view.InputView
import menu.view.OutputView

class DietMenuController(
    private val inputView: InputView,
    private val outputView: OutputView
) {

    private val categoryRecommandService: CategoryRecommandService = CategoryRecommandService(GenerateRandomNumbers())
    private lateinit var weeklyCategory: WeeklyCategory
    private lateinit var coaches: Coaches

    init {
        generateWeeklyCategory()
    }

    fun startRecommend() {
        inputView.startMenuRecommand()
        setCoaches()
        setIndevidible()
    }

    private fun setIndevidible() {
        coaches.forEach { coach ->
            val input = inputView.inedibleFood(coach)
            if (input.isEmpty()) return@forEach
            input.split(",").forEach { inedibleFood ->
                coach.addInedible(Food(foodCategory = FoodCategory.categoryOfFoodName(inedibleFood), inedibleFood))
            }
        }
    }

    private fun setCoaches() {
        coaches = Coaches(
            inputView.coachName().split(",").map { name ->
                Coach(name = name.trim())
            }
        )
    }

    private fun generateWeeklyCategory() {
        weeklyCategory = WeeklyCategory(categoryRecommandService.generateWeekCategory())
    }


}