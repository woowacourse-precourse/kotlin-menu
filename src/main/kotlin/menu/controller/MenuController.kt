package menu.controller

import menu.view.Input
import menu.view.Output

class MenuController {

    var hateFood = ArrayList<List<String>>()

    fun run() {
        Output().printStart()
        val coachName = Input().InputName()
        println(coachName)

        coachHateFood(coachName)
        println(hateFood)

        Output().printResultPhrases()
    }

    fun coachHateFood(coachGroup : List<String>){
        for (i in 0 until coachGroup.size){
            hateFood.add(Input().InputHateFood(coachGroup[i]))
            println()
        }
    }
}