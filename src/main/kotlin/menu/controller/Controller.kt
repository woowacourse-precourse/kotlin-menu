package menu.controller

import menu.domain.Coach
import menu.domain.Recommend
import menu.utils.RepeatInputProcess
import menu.view.InputView
import menu.view.OutputView

@Suppress("UNCHECKED_CAST")
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
            coaches.forEach {
                recommendCoachMenu(category, it)
            }
        }
    }

    private fun recommendCoachMenu(category: String, coach: Coach) {
        val menu = recommend.recommendCategoryMenu(category, coach)
        coach.addRecommendedMenus(menu)
    }

    private fun readCoaches(): List<Coach> {
        val coaches = mutableListOf<Coach>()
        outputView.printInputCoachNamesMent()
        val names = RepeatInputProcess.repeat { inputView.readCoachNames() } as List<String>
        names.forEach {
            coaches.add(Coach(it))
        }
        return coaches
    }

    private fun readCantEatMenu(coaches: List<Coach>) {
        coaches.forEach {
            outputView.printInputCantEatMenuMent(it.name)
            it.setCantEatMenus(RepeatInputProcess.repeat { inputView.readCantEatMenus() } as List<String>)
        }
    }
}