package menu

import menu.controller.InputValidator
import menu.controller.RecommendSimulator
import menu.view.OutputView

fun main() {
    try {
        val recommendSimulator = RecommendSimulator(InputValidator(), OutputView())
        recommendSimulator.run()

    } catch (e: IllegalArgumentException) {
        println(e.message)
        throw e
    }
}
