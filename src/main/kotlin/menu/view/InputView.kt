package menu.view

import camp.nextstep.edu.missionutils.Console.readLine
import menu.exceptions.Exceptions

class InputView {
    private val exceptions = Exceptions()

    fun getCoachNames(): List<String> {
        val input = readLine()
        exceptions.validateCoachNames(input)
        return input.split(",")
    }

    fun getCoachBias(): List<String> {
        val input = readLine()
        exceptions.validateCoachBias(input)
        return input.split(",")
    }
}