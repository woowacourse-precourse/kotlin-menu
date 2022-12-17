package menu.controller

import menu.domain.CategoryMaker
import menu.domain.CoachGenerator
import menu.dto.CategoriesDTO
import menu.dto.CoachesDTO
import menu.dto.MenusDTO
import menu.dto.NamesDTO
import menu.view.InputView
import menu.view.OutputView

class RecommendController(
    private val categoryMaker: CategoryMaker,
    private val coachGenerator: CoachGenerator,
    private val inputView: InputView,
    private val outputView: OutputView
) {
    private lateinit var categoriesDTO: CategoriesDTO
    private lateinit var coachesDTO: CoachesDTO
    private lateinit var menusDTO: MenusDTO
    private lateinit var namesDTO: NamesDTO
    private val coachInputs = mutableMapOf<String, List<String>>()

    fun startService() {
        outputView.printStart()
        outputView.printInterval()

        setUpCoaches()

        selectCategories()
        recommendMenus()

        finishService()
    }

    private fun setUpCoaches() {
        getNames()
        outputView.printInterval()

        val names = namesDTO.getNames()
        names.map { name ->
            getMenus(name)
            coachInputs.put(name, menusDTO.getMenus())
            outputView.printInterval()
        }

        coachesDTO = coachGenerator.generate(coachInputs)
    }

    private fun getNames() {
        var success = false
        do {
            try {
                namesDTO = inputView.readNames()
                success = true
            } catch (exception: IllegalArgumentException) {
                outputView.printError(exception.message ?: "")
            }
        } while (!success)
    }

    private fun getMenus(name: String) {
        var success = false
        do {
            try {
                menusDTO = inputView.readMenus(name)
                success = true
            } catch (exception: IllegalArgumentException) {
                outputView.printError(exception.message ?: "")
            }
        } while (!success)
    }

    private fun selectCategories() {
        categoriesDTO = categoryMaker.make()
    }

    private fun recommendMenus() {
        val categories = categoriesDTO.getCategories()
        val coaches = coachesDTO.getCoaches()
        categories.map {category ->
            coaches.map { coach -> coach.recommendMenu(category) }
        }
    }

    private fun finishService() {
        outputView.printFinish(categoriesDTO, coachesDTO)
    }
}