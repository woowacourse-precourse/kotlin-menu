package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.constants.Exception.Companion.EXCEPTION_INVALID_COACH_NUM
import menu.constants.Exception.Companion.EXCEPTION_INVALID_NAME_LENGTH
import menu.constants.Exception.Companion.EXCEPTION_IS_NOT_MENU
import menu.model.Menu

class InputView {
    private val outputView = OutputView()
    private val japan = Menu.JAPAN
    private val korean = Menu.KOREAN
    private val china = Menu.CHINA
    private val asian = Menu.ASIAN
    private val western = Menu.WESTERN
    fun readCoachName(): List<String> {
        outputView.printInputCoachName()
        val names = Console.readLine()
        val coach = names.split(",")
        checkCoachName(coach) // 유효성 검사
        return coach
    }

    private fun checkCoachName(coach: List<String>) {
        if (coach.size < 2 || coach.size > 4) {
            outputView.printException(EXCEPTION_INVALID_COACH_NUM)
            throw IllegalArgumentException(EXCEPTION_INVALID_COACH_NUM)
        }
        for (name in coach) {
            if (name.length < 2 || name.length > 5) {
                outputView.printException(EXCEPTION_INVALID_NAME_LENGTH)
                throw IllegalArgumentException(EXCEPTION_INVALID_NAME_LENGTH)
            }
        }
    }

    fun readFoodBan(name: String): List<String> {
        outputView.printInputFoodBan(name)
        val input = Console.readLine()
        val banFood = input.split(",")
        checkbanFood(banFood) // 유효성 검사
        return banFood
    }

    private fun checkbanFood(banFood: List<String>) {
        var isExist = false
        for (food in banFood) {
            if (japan.menu.contains(food) || korean.menu.contains(food) || china.menu.contains(food) || asian.menu.contains(
                    food
                ) || western.menu.contains(food)
            ) {
                isExist = true
                return
            }
        }
        if (!isExist) {
            outputView.printException(EXCEPTION_IS_NOT_MENU)
            throw IllegalArgumentException(EXCEPTION_IS_NOT_MENU)
        }
    }


}