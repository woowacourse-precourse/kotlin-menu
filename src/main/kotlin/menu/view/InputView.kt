package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.util.InputValidator

class InputView(
    private val inputValidator: InputValidator = InputValidator()
) {
    fun inputCoaches(): List<String> {
        println(COACH_NAMES_INPUT_MESSAGE)
        val coachNames = input().trim().split(",")
        printEnter()
        return inputValidator.validateCoachesNames(coachNames)
    }

    private fun input(): String = Console.readLine()

    private fun printEnter() = println()

    companion object {
        private const val COACH_NAMES_INPUT_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)"
    }
}