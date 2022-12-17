package menu

import camp.nextstep.edu.missionutils.Randoms

class OutputVIew {
    fun showMenu() : MutableList<String>{
        println("메뉴 추천 결과입니다.")
        println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]")

        // 1이면 일식, 2면 한식, 3이면 중식, 4면 아시안, 5면 양식
        val categories: MutableList<String> = mutableListOf("", "일식", "한식", "중식", "아시안", "양식")
        var diet = mutableListOf<String>()

        // 카테고리 추천
        print("[ 카테고리")
        for (i in 0 until 5) {
            val category: String = categories.get(Randoms.pickNumberInRange(1, 5))
            diet.add(category)
            print(" | ")
            print(category)
        }
        println(" ]")

        return diet
    }


}