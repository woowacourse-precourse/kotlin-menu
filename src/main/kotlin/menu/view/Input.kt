package menu.view

import menu.values.Strings
import camp.nextstep.edu.missionutils.Console
import menu.utils.Validator

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

    fun printSize(): List<String> {
        while (true){
            try {
                val coachName = Input().InputName()
                Validator().checkInputName(coachName as ArrayList<String>)
                Validator().checkInputGROUP(coachName)
                return coachName
            } catch (e: IllegalArgumentException) {
                println(e)
                println("\n")
            }
        }
    }
}
