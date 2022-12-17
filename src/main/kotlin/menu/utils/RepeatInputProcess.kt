package menu.utils

import menu.view.OutputView
import java.lang.IllegalArgumentException

object RepeatInputProcess {
    private val outputView = OutputView()
    fun repeat(inputProcess: () -> Any): Any {
        while (true) {
            try {
                return inputProcess()
            } catch (e: IllegalArgumentException) {
                outputView.printErrorMessage(e.message.toString())
            }
        }
    }
}