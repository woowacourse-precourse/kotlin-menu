package menu.view

import menu.values.Strings
import java.io.BufferedReader
import java.io.InputStreamReader
import camp.nextstep.edu.missionutils.Console

class input {


    fun printStart() {
        println(Strings.START.message)
        println()
    }


    fun InputName(): List<String> {
        var coachName = ArrayList<String>()
        println(Strings.INPUT_NAME.message)
        coachName = Console.readLine().split(",").map { it } as ArrayList<String>

        return coachName
    }

    fun InputHateFood(coach: String): List<String> {
        println("${coach}" + Strings.INPUT_HATEFOOD.message)
        val hateFood = Console.readLine().split(",").map { it } as ArrayList<String>
        return hateFood
    }
}
