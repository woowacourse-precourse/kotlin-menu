package menu.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    private val outputView = OutputView()
    private val viewValidate = ViewValidate()

    fun readCoachesName():List<String> {
        outputView.printInputCoachNames()
        val coachNames = Console.readLine()
        viewValidate.coachNamesForm(coachNames)
        return coachNames.split(",")
    }
}