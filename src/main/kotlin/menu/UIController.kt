package menu

import camp.nextstep.edu.missionutils.Console
import java.lang.Error

class UIController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val validateService = ValidateService()

    fun start() {
        outputView.printStart()
    }

    fun getCoachName(): List<String> {
        while (true) {
            val coaches = inputView.getCoachName()
            runCatching {
                validateService.validateCoachName(coaches)
            }.onSuccess { return coaches }.onFailure { println(it.message) }
        }
    }

    fun getCoachHateMenu(coaches: List<String>): Map<String, List<String>> {
        val coachHateMenu = mutableMapOf<String, List<String>>()
        for (coach in coaches) {
            coachHateMenu[coach] = getOneCoachHateMenu(coach)
        }
        return coachHateMenu
    }

    private fun getOneCoachHateMenu(name: String): List<String> {
        while (true) {
            val coachHateMenu = inputView.getHateMenu(name)
            runCatching {
                validateService.validateHateMenu(coachHateMenu)
            }.onSuccess { return coachHateMenu }.onFailure { println(it.message) }
        }
    }

    fun printResult(category: List<String>, recommendations: Map<String, List<String>>) {
        outputView.printResult(category, recommendations)
    }

}