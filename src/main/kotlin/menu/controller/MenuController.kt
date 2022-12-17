package menu.controller

import menu.view.input

class MenuController {

    var hateFood = ArrayList<List<String>>()

    fun run() {
        input().printStart()
        val coachName = input().InputName()
        println(coachName)

        coachHateFood(coachName)
        println(hateFood)
    }

    fun coachHateFood(coachGroup : List<String>){
        for (i in 0 until coachGroup.size){
            hateFood.add(input().InputHateFood(coachGroup[i]))
        }
    }
}