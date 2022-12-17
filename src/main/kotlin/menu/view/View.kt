package menu.view

import menu.Coach

class View {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun getCoachName(): List<String> {
        outputView.printStartMessage()
        outputView.requestCoachNames()
        return try {
            inputView.getCoachNames()
        } catch (e: IllegalArgumentException) {
            println(e)
            getCoachName()
        }
    }

    fun getCoachesBias(coaches: MutableList<Coach>) {
        for (coach in coaches) {
            outputView.requestCoachBias(coach)
            getCoachBias(coach)
        }
    }

    private fun getCoachBias(coach: Coach) {
        try {
            coach.saveBias(inputView.getCoachBias())
        } catch (e: IllegalArgumentException) {
            println(e)
            getCoachBias(coach)
        }
    }

    fun printResultRecommend(coaches: MutableList<Coach>) {
        outputView.printResultMessage()
        outputView.printRecommendResult(coaches)
        outputView.printEndMessage()
    }
}