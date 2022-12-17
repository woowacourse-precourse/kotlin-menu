package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.utils.Exception.coachNameInputException
import menu.utils.Exception.coachPersonnelInputException
import menu.utils.Exception.coachUneatableMenuInputException


class InputView {
    fun getCoachName(): List<String> {
        while (true) {
            val coachName = Console.readLine()!!
            kotlin.runCatching {
                coachName.coachPersonnelInputException()
                coachName.coachNameInputException()
            }.onSuccess { return coachName.trim().split(",") }.onFailure { println(it.message) }
        }
    }

    fun getCoachUneatableMenu(coach: String): List<String> {
        OutputView().coachUneatableMenuPrint(coach)
        return Console.readLine().coachUneatableMenuInputException().trim().split(",").toSet().toList()
    }
}