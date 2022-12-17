package menu.view

class OutputView {

    fun printStartMessage() {
        printMessage(START_MESSAGE)
    }

    fun printMessage(message: String) = println(message)

    fun printEnter() = println()

    fun printError(error: Exception) {
        printMessage(error.message!!)
        printEnter()
    }

    companion object {
        private const val START_MESSAGE = "점심 메뉴 추천을 시작합니다.\n"
    }
}