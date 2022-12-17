package menu.view

class OutputView {

    fun printMessage(message: String) {
        println(message)
    }

    fun printErrorMessage(e: IllegalArgumentException) {
        println(e.message)
    }

    companion object {

    }

}