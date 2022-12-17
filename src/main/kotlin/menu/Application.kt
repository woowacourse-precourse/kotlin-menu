package menu

import menu.view.InputView
import menu.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val menuMission = MenuMission(inputView,outputView)
    menuMission.missionStart()
}
