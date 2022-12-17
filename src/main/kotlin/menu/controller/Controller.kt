package menu.controller

import menu.domain.Coach
import menu.domain.Recommend
import menu.utils.RepeatInputProcess
import menu.view.InputView
import menu.view.OutputView

class Controller {
    private val outputView = OutputView()
    private val inputView = InputView()
    private val recommend = Recommend()
    private val categories = mutableListOf<String>()

    init {
        outputView.printStartMent()
    }

    fun operate() {
        val coaches = readCoaches()
        readCantEatMenu(coaches)
        recommend(coaches)
        outputView.printResult(categories, coaches)
    }

    private fun recommend(coaches: List<Coach>) {
        while (categories.size < 5) {
            val category = recommend.recommendCategory(categories)
            categories.add(category)
            coaches.forEach { coach ->
                recommendMenu(category, coach)
            }
        }
    }

    private fun recommendMenu(category: String, coach: Coach) {
        val menu = recommend.recommendMenu(coach, category)
        coach.addRecommendedMenus(menu)
    }

    private fun readCoaches(): List<Coach> {
        val coaches = mutableListOf<Coach>()
        outputView.printInputCoachNamesMent()
        @Suppress("UNCHECKED_CAST")
        val names = RepeatInputProcess.repeat { inputView.readCoachNames() } as List<String>
        names.forEach { name ->
            coaches.add(Coach(name))
        }
        return coaches
    }

    private fun readCantEatMenu(coaches: List<Coach>) {
        coaches.forEach { coach ->
            outputView.printInputCantEatMenuMent(coach.name)
            @Suppress("UNCHECKED_CAST")
            coach.setCantEatMenus(RepeatInputProcess.repeat { inputView.readCantEatMenus() } as List<String>)
        }
    }
}
