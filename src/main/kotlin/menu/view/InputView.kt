package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.utils.Exception.coachNameInputException
import menu.utils.Exception.coachPersonnelInputException


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

    fun getCoachUneatableMenu(coach: List<String>): Set<String> {
        val uneatableMenu = mutableListOf<String>()
        coach.forEach {
            OutputView().coachUneatableMenuPrint(it)
            uneatableMenu.addAll(Console.readLine()!!.trim().split(","))
        }
        return uneatableMenu.toSet()
    }
}