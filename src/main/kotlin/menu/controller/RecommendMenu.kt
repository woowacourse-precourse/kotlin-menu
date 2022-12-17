package menu.controller

import menu.model.Category
import menu.model.Coach
import menu.model.Week
import menu.view.InputView
import menu.view.OutputView

class RecommendMenu {

    private val inputView = InputView()
    private val outputView = OutputView()
    private val week = Week()
    private val category = Category()


    fun execute() {
        outputView.printStart()
        val coachesName = inputView.readCoachesName()
        var coaches = getCoaches(coachesName)
        coaches = coaches.map { coach -> getExcludeFoods(coach) }
        repeat(week.getDayOfWeek().size) {
            coaches = coaches.map { coach -> recommend(coach) }
            week.addMenus(category.getRandomCategories())
        }
        outputView.printRecommendResult(week, coaches)
        outputView.printEnd()
    }

    fun getCoaches(coachNames: List<String>): List<Coach> {
        return coachNames.map { coachName ->
            Coach(coachName)
        }
    }

    fun getExcludeFoods(coach: Coach): Coach {
        val coach = coach
        val excludeFoods = inputView.readExcludedFoods(coach.getName())
        coach.addExcludeMenus(excludeFoods)
        return coach
    }

    fun recommend(coach: Coach): Coach {
        val food = category.getCategoryFood()
        coach.recommend(food)
        return coach
    }
}