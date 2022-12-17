package menu

import camp.nextstep.edu.missionutils.Randoms

class MenuRecommend {
    /** 1:일식, 2:한식, 3:중식, 4:아시안, 5:양식 **/
    fun pickCategory() : String{
        val categories = listOf("일식", "한식", "중식", "아시안", "양식")
        val category: String = categories.get(Randoms.pickNumberInRange(1, 5))

        return category
    }
}