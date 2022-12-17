package menu.domain

import camp.nextstep.edu.missionutils.Randoms

class Food {

    fun choiceFood(foodList: ArrayList<String>) : String{
        val menu: String = Randoms.shuffle(foodList)[0]

        return menu
    }
}