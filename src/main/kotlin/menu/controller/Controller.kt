package menu.controller

import menu.domain.*
import menu.domain.category.CategoriesRandomGenerator
import menu.domain.menu.MenuRandomGenerator
import menu.view.InputView
import menu.view.OutputView

class Controller {

    private val outputView = OutputView()
    private val inputView = InputView()
    private val launchMenuService = LaunchMenuService()
    private lateinit var coach: Coach
    private lateinit var categories: List<Category>

    fun run() {
        outputView.printServiceStart()
        getCoachInformation()
        outputView.printMenuResultInitialMessage()
        outputView.printDayOfTheWeekMessage()
        getCategories()
        getCoachMenus()
        outputView.printServiceEnd()
    }

    fun getCoachInformation() {
        val coachNames = inputView.readCoaches()
        val impossibleMenus = mutableListOf<List<String>>()
        coachNames.forEach { coachName ->
            impossibleMenus.add(inputView.readImpossibleFood(coachName))
        }
        coach = Coach(coachNames, impossibleMenus)
    }

    fun getCategories() {
        categories = launchMenuService.getCategories(CategoriesRandomGenerator())
        outputView.printCategories(launchMenuService.categoryToString(categories))
    }

    fun getCoachMenus() {
        for (index in 0 until coach.name.size) {
            getCoachMenu(index)
        }
    }

    fun getCoachMenu(index: Int) {
        val menus = launchMenuService.getMenus(categories, coach.impossibleMenus[index], MenuRandomGenerator())
        outputView.printMenus(coach.name[index], menus)
    }

}