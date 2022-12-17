package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.util.DuplicationRemover
import menu.util.InputValidator

class InputView(
    private val inputValidator: InputValidator = InputValidator(),
) {
    fun inputCoaches(): List<String> {
        println(COACH_NAMES_INPUT_MESSAGE)
        val coachNames = input().trim().split(",")
        val nonDuplicatedCoachNames = DuplicationRemover.removeDuplication(coachNames)
        printEnter()
        return inputValidator.validateCoachesNames(nonDuplicatedCoachNames)
    }

    fun inputInedibleFoods(): List<String> {
        val inedibleFoods = input().trim().split(",")
        val nonDuplicatedInedibleFoods = DuplicationRemover.removeDuplication(inedibleFoods)
        printEnter()
        return inputValidator.validateInedibleFoods(nonDuplicatedInedibleFoods)
    }

    private fun input(): String = Console.readLine()

    private fun printEnter() = println()

    companion object {
        private const val COACH_NAMES_INPUT_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)"
    }
}