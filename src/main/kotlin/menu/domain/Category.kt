package menu.domain
import camp.nextstep.edu.missionutils.Randoms

class Category {


    fun choiceCategory() : String{
        return Randoms.pickNumberInRange(1, 5).toString()
    }


}