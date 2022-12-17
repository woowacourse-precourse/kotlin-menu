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
        val categoryGenerator = CategoryGenerator()
        val category = categoryGenerator.makeCategory()
        val menuList = mutableListOf<Menu>()
        coachList.getCoach().forEach { coach ->
            val food = getFood(coach)
            menuList.add(getMenu(category, food))
        }
        output.printCategories(categoryGenerator.toStringCategory(category))

    }

    private fun getMenu(categories: List<Int>, food: Food): Menu {
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
        return Menu(menus)
    }

    private fun getCoach(): Coach {
        output.printRequestName()
        return input.getValidatedCoach()
    }

    private fun getFood(coach: String): Food {
        output.printRequestFood(coach)
        return input.getValidatedFood()
    }
}