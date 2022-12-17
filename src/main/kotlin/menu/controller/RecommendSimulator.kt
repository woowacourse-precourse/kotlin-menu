package menu.controller

import menu.domain.CategoryGenerator
import menu.model.Coach
import menu.model.Food
import menu.model.Menu
import menu.view.OutputView
import camp.nextstep.edu.missionutils.Randoms.shuffle
import menu.resource.*

class RecommendSimulator(
    private val input: InputValidator,
    private val output: OutputView,
) {
    init {
        output.printStartRecommend()
    }

    fun run() {
        val coachList = getCoach()
        val category = CategoryGenerator().makeCategory()
        val menuList = mutableListOf<Menu>()
        coachList.getCoach().forEach { coach ->
            val food = getFood(coach)
            getMenu(category, food)
        }
    }

    /* 1. 각 food와 coach에 따라 menu를 추천하고, 해당 값을 저장한다.

     */
    private fun getMenu(categories: List<Int>, food: Food) {
        val menus = mutableListOf<String>()

        for (category in categories) {
            val menu = when (category) {
                1 -> FOOD_JAPAN
                2 -> FOOD_KOREA
                3 -> FOOD_CHINA
                4 -> FOOD_ASIA
                5 -> FOOD_USA
                else -> null
            }
            val randomMenu = shuffle(menu)[0]
            if (!menus.contains(randomMenu) && !food.getFood().contains(randomMenu)) menus.add(randomMenu)
        }
        println(categories)
        println(menus)
        //val menu: String = shuffle(menus)[0]


    }

    private fun getCoach(): Coach {
        try {
            output.printRequestName()
            return input.getValidatedCoach()

        } catch (e: IllegalArgumentException) {
            throw e
        }
    }

    private fun getFood(coach: String): Food {
        try {
            output.printRequestFood(coach)
            return input.getValidatedFood()

        } catch (e: IllegalArgumentException) {
            throw e
        }
    }
}