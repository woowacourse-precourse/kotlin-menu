package menu.domain

import menu.ui.OutputView

class UserController {
    private val outputView = OutputView()

    fun programRun(){
        outputView.printInitNotice()
    }
}