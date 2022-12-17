package menu.model

import camp.nextstep.edu.missionutils.Randoms

class FoodRandomGenerator {

    fun generate(menus : List<String>) : String = Randoms.shuffle(menus)[0]

}