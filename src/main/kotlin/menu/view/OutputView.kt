package menu.view

import menu.INSERT_CANNOT_EAT

class OutputView {
    fun printMessage(msg: String) {
        println(msg)
    }

    fun printCanNotEat(name: String) {
        println(name + INSERT_CANNOT_EAT)
    }

    fun printErrorMessage(msg: String) {
        println("[ERROR] $msg")
    }
}