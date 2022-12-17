package menu.view

import menu.values.Strings
import camp.nextstep.edu.missionutils.Console

class Input {

    fun InputName(): List<String> {
        var coachName = ArrayList<String>()
        Output().printInputCoachName()
        coachName = Console.readLine().split(",").map { it } as ArrayList<String>

        return coachName
    }

    fun InputHateFood(coach: String): List<String> {
        Output().printInputHateFoo(coach)
        val hateFood = Console.readLine().split(",").map { it } as ArrayList<String>
        return hateFood
    }
}
