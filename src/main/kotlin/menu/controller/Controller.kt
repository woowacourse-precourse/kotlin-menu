package menu.controller

import menu.model.CategoryMaker
import menu.model.CategoryRandomGenerator
import menu.model.Coach
import menu.util.Validator
import menu.view.InputView
import menu.view.OutputView

class Controller {

    private val input by lazy { InputView() }
    private val output by lazy { OutputView() }
    private val validator by lazy { Validator() }
    private val categories = CategoryMaker(CategoryRandomGenerator()).makeCategories()
    private val coaches = mutableListOf<Coach>()

    fun run() {
        output.printStartMessage()
        handleCoaches()
    }

    fun handleCoaches() {
        output.printInputCoachesNameMessage()
        val coachesInput = inputCoachesName()
        coachesInput.forEach {
            output.printInputFoodsNameMessage(it)
            val hateFoods = inputFoodsName()
            coaches.add(Coach(it, hateFoods, categories))
        }
    }

    fun inputCoachesName() : List<String> = getCoachesName(input.inputCoachesName())

    fun getCoachesName(input : String) : List<String> {
        try {
            validator.checkCoachesInput(input)
            return input.split(",").toList()
        } catch(e: IllegalArgumentException) {
            output.printError(e)
            return inputCoachesName()
        }
    }

    fun inputFoodsName() : List<String> = getFoodsName(input.inputFoodsName())

    fun getFoodsName(input : String) : List<String> {
        try {
            Validator().checkFoodsInput(input)
            return input.split(",").toList()
        } catch (e : IllegalArgumentException) {
            output.printError(e)
            return inputFoodsName()
        }
    }
}