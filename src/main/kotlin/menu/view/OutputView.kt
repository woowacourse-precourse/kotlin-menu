package menu.view

class OutputView {
    fun printMessage(msg:String) {
        println(msg)
    }

    fun printErrorMessage(msg:String) {
        println("[ERROR] $msg")
    }
}