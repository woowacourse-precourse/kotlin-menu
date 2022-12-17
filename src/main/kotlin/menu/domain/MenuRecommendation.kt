package menu.domain

import menu.view.InputView
import menu.view.OutputView

class MenuRecommendation(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    private lateinit var coachName: List<String>
    private val menusCantEat = mutableListOf<List<String>>()

    fun start() {
        outputView.printStart()
        // TODO: 코치 이름 및 메뉴 앞뒤 공백 처리
        coachName = inputCoachName()
        println(coachName)
        coachName.forEach { name -> menusCantEat.add(inputMenuCantEat(name)) }
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