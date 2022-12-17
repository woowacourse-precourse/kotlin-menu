package menu.view

class OutputView {

    fun printStartMessage() {
        printMessage(START_MESSAGE)
    }

    fun printInedibleFoodInputMessage(coachName: String) {
        println(INEDIBLE_FOOD_INPUT_MESSAGE.format(coachName))
    }

    fun printMessage(message: String) = println(message)

    fun printEnter() = println()

    fun printError(error: Exception) {
        printMessage(error.message!!)
        printEnter()
    }

    companion object {
        private const val START_MESSAGE = "점심 메뉴 추천을 시작합니다.\n"
        private const val INEDIBLE_FOOD_INPUT_MESSAGE = "%s(이)가 못 먹는 메뉴를 입력해 주세요."
    }
}