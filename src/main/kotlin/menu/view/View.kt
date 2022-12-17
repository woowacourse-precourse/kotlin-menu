package menu.view

import menu.data.Coach

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

    fun printResultRecommend(coaches: MutableList<Coach>, categories: List<String>) {
        outputView.printResultMessage()
        outputView.printRecommendResult(coaches, categories)
        outputView.printEndMessage()
    }
}