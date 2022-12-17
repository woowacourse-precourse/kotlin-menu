package menu

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val inputValidator = InputValidator()
    val controller = Controller(inputView, outputView, inputValidator)
    controller.run()
}
