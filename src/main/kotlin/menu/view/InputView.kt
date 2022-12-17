package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.validation.InputValidation

class InputView {
    private val inputValidation = InputValidation()

    fun readCoaches(): List<String> {
        println(INPUT_COACH_NAME_MESSAGE)
        return try {
            val input = Console.readLine()
            val coaches = inputValidation.checkNumberOfCoach(input)
            inputValidation.checkCoachNameLength(coaches)
            coaches
        } catch (e: IllegalArgumentException) {
            println(e.message)
            readCoaches()
        }
    }

    fun readImpossibleFood(coach: String): List<String> {
        println(coach + INPUT_FOOD_NAME_MESSAGE)
        return try {
            val input = Console.readLine()
            val foods = inputValidation.checkNumberOfImpossibleFood(input)
            inputValidation.checkInvalidImpossibleFood(foods)
            foods
        } catch (e: IllegalArgumentException) {
            println(e.message)
            readImpossibleFood(coach)
        }
    }

    companion object {
        const val INPUT_COACH_NAME_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)"
        const val INPUT_FOOD_NAME_MESSAGE = "(이)가 못 먹는 메뉴를 입력해 주세요."
    }

}