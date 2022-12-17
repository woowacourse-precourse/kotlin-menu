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
    private val menusCantEat = mutableListOf<List<String>>()
    private val categoriesGonnaEat = mutableListOf<Category>()

    fun start() {
        outputView.printStart()

        // TODO: 코치 이름 및 메뉴 앞뒤 공백 처리
        coachName = inputCoachName()
        println(coachName)
        coachName.forEach { name -> menusCantEat.add(inputMenuCantEat(name)) }

        getCategories()
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