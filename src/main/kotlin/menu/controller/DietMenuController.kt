package menu.controller

import menu.domain.CategoryRecommandService
import menu.domain.GenerateRandomNumbers
import menu.domain.model.*
import menu.util.COMMA
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
        setInedible()
        lunchRecommand()
    }

    private fun lunchRecommand() {
        weeklyCategory.forEach { weekday ->
            addRandomFood(weekday)
        }
        outputView.menuRecommandResults(weeklyCategory, coaches)
    }

    private fun addRandomFood(weekday: Weekday) {
        coaches.forEach { coach ->
            var randomFood: Food
            do {
                randomFood = weekday.getRandomFood()
            } while (coach.checkFood(randomFood))
            coach.addDiet(randomFood)
        }
    }

    private fun setInedible() {
        coaches.forEach { coach ->
            val inedibleFoods = inputView.inedibleFood(coach)
            if (inedibleFoods.isEmpty()) return@forEach // 공백일 때 패스
            inedibleFoods.split(COMMA).forEach { inedibleFood ->
                coach.addInedible(Food(FoodCategory.categoryOfFoodName(inedibleFood.trim()), inedibleFood.trim()))
            }
        }
    }

    private fun setCoaches() {
        coaches = Coaches(
            inputView.coachName().split(COMMA).map { name ->
                Coach(name = name.trim())
            }
        )
    }

    private fun generateWeeklyCategory() {
        weeklyCategory = WeeklyCategory(categoryRecommandService.generateWeekCategory())
    }


}