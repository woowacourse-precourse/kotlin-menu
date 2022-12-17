package menu

import menu.view.InputView

class MenuMission(private val inputView: InputView) {
    fun missionStart() {
        inputView.getCoach()
    }


}