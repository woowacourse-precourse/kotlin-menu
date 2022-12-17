package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.utils.Exception.coachNameInputException


class InputView {
    fun getCoachName(): List<String> {
        while (true) {
            val coachName = Console.readLine()!!
            kotlin.runCatching {
                coachName.coachNameInputException()
            }.onSuccess { return coachName.trim().split(",") }.onFailure { println(it.message) }
        }
    }
}