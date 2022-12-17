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
    private val categoriesGonnaEat = mutableListOf<Category>()

    fun start() {
        outputView.printStart()

        // TODO: 코치 이름 및 메뉴 앞뒤 공백 처리
        coachName = inputCoachName()
        println(coachName)
        coachName.forEach { name -> menusCantEat[name] = inputMenuCantEat(name) }

        getCategories()
        getRecommendMenu()
    }

    fun getCategories() {
        while (categoriesGonnaEat.size < NUM_OF_DAYS) {
            val index = pickNumberInRange(1, 5)
            val category = Category.getCategoryByIndex(index)

            if (categoriesGonnaEat.count { it == category } < MAX_DUPLICATE_CATEGORY) {
                categoriesGonnaEat.add(category)
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
            val menu = Randoms.shuffle(Category.getMenus(categoriesGonnaEat[day]))[0]

            if (canEatMenu(coach, menu) && !isAlreadyHad(coach, menu)) {
                addMenu(coach, menu)
                break
            }
        }
    }

    fun canEatMenu(coach: String, menu: String): Boolean {

    }

    fun isAlreadyHad(coach: String, menu: String): Boolean {

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
}