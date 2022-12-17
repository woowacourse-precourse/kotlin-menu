package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.service.ExceptionHandler

class InputView {
    fun getCoachNames(): List<String> {
        var names = ""
        do {
            names = Console.readLine().trim()
        } while (!ExceptionHandler.isValidNameLength(names)
            || !ExceptionHandler.isValidNumber(names.split(",").size)
        )

        return names.split(",")
    }

    fun getUnavailableFoods(): List<String> {
        var foods = ""
        do {
            foods = Console.readLine()
        } while (!ExceptionHandler.isValidUnavailableFoods(foods.split(",").size))
        return foods.split(",")
    }
}