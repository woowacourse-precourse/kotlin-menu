package menu.controller

import menu.dto.MenusDTO
import menu.dto.NamesDTO
import menu.view.InputView
import menu.view.OutputView

class RecommendController(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    private lateinit var namesDTO: NamesDTO
    private lateinit var menusDTO: MenusDTO

    fun startService() {
        outputView.printStart()
        outputView.printInterval()

        setUpCoaches()
    }

    private fun setUpCoaches() {}

    private fun getNames() {
        var success = false
        do {
            try {
                namesDTO = inputView.readNames()
                success = true
            } catch (exception: IllegalArgumentException) {
                outputView.printError(exception.message ?: "")
            }
        } while (!success)
    }

    private fun getMenus(name: String) {
        var success = false
        do {
            try {
                menusDTO = inputView.readMenus(name)
                success = true
            } catch (exception: IllegalArgumentException) {
                outputView.printError(exception.message ?: "")
            }
        } while (!success)
    }
}