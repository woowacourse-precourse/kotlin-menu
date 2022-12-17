package menu.view

import camp.nextstep.edu.missionutils.Console
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
            outputView.printException("[ERROR]")
            throw IllegalArgumentException("[ERROR]")
        }
        for (name in coach) {
            if (name.length < 2 || name.length > 5) {
                outputView.printException("[ERROR]")
                throw IllegalArgumentException("[ERROR]")
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

    fun checkbanFood(banFood: List<String>) {
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
            outputView.printException("[ERROR]")
            throw IllegalArgumentException("[ERROR]")
        }
    }


}