package menu

import menu.view.InputView

fun main() {
    val inputView = InputView()
    val menuMission = MenuMission(inputView)
    menuMission.missionStart()
}
