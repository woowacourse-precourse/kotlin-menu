package menu.domain

import camp.nextstep.edu.missionutils.Randoms
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
    private val menusCantEat = mutableMapOf<String, List<String>>()
    private val menusGonnaEat = mutableMapOf<String, MutableList<String>>()
    private val categories = mutableListOf<Category>()

    fun start() {
        outputView.printStart()

        coachName = removeTrims(inputCoachName())
        println(coachName)
        coachName.forEach { name -> menusCantEat[name] = inputMenuCantEat(name) }

        getCategories()
        getRecommendMenu()

        outputView.printResult(categories, menusGonnaEat)
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
            for (coach in coachName) {
                getMenu(day, coach)
            }
        }
    }

    fun getMenu(day: Int, coach: String) {
        while (true) {
            val menu = Randoms.shuffle(Category.getMenus(categories[day]))[0]

            if (canEatMenu(coach, menu) && !isAlreadyHad(coach, menu)) {
                addMenu(coach, menu)
                break
            }
        }
    }

    fun canEatMenu(coach: String, menu: String): Boolean {
        if (menusCantEat[coach]!!.contains(menu)) {
            return false
        }
        return true
    }

    fun isAlreadyHad(coach: String, menu: String): Boolean {
        val eatMenu = menusGonnaEat[coach] ?: mutableListOf()

        if (eatMenu.contains(menu)) {
            return true
        }

        return false
    }

    fun addMenu(coach: String, menu: String) {
        val eatMenu = menusGonnaEat[coach] ?: mutableListOf()
        eatMenu.add(menu)
        menusGonnaEat[coach] = eatMenu
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