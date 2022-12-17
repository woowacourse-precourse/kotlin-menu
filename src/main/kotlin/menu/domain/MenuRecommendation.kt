package menu.domain

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import menu.domain.resource.MAX_DUPLICATE_CATEGORY
import menu.domain.resource.NUM_OF_DAYS
import menu.view.InputView
import menu.view.OutputView

class MenuRecommendation(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    private lateinit var coachName: List<String>
    private val coaches = mutableListOf<Coach>()
    private val categories = mutableListOf<Category>()

    fun start() {
        outputView.printStart()

        coachName = removeTrims(inputCoachName())
        coachName.forEach { name -> coaches.add(Coach(name, inputMenuCantEat(name))) }

        getCategories()
        getRecommendMenu()

        outputView.printResult(categories, coaches)
    }

    fun getCategories() {
        while (categories.size < NUM_OF_DAYS) {
            val index = pickNumberInRange(1, 5)
            val category = Category.getCategoryByIndex(index)

            if (categories.count { it == category } < MAX_DUPLICATE_CATEGORY) {
                categories.add(category)
            }
        }
    }

    fun getRecommendMenu() {
        for (day in 0 until NUM_OF_DAYS) {
            coaches.forEach {
                it.getMenu(categories[day])
            }
        }
    }

    fun inputCoachName(): List<String> {
        while (true) {
            try {
                return inputView.readCoachName()
            } catch (e: IllegalArgumentException) {
                println(e.message)
                continue
            }
        }
    }

    fun inputMenuCantEat(name: String): List<String> {
        while (true) {
            try {
                return inputView.readMenuCantEat(name)
            } catch (e: IllegalArgumentException) {
                println(e.message)
                continue
            }
        }
    }

    fun removeTrims(value: List<String>): MutableList<String> {
        val result = mutableListOf<String>()
        value.forEach {
            result.add(it.trim())
        }
        return result
    }
}