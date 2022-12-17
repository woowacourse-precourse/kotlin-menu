package menu

import camp.nextstep.edu.missionutils.Randoms

class Menu {

    fun categorySelect(): List<String>{
        var categoryCollect= mutableListOf<String>()
        var categoryNumberCollect= mutableListOf<String>()
        while (true){
            if (categoryNumberCollect.size==5) break
            val categoryNumber: Int = Randoms.pickNumberInRange(1, 5)
            if (categoryNumberCollect.count { it == categoryNumber.toString() }>2) continue
            categoryNumberCollect.add(categoryNumber.toString())
            if (categoryNumber==1) categoryCollect.add("일식")
            if (categoryNumber==2) categoryCollect.add("한식")
            if (categoryNumber==3) categoryCollect.add("중식")
            if (categoryNumber==4) categoryCollect.add("아시안")
            if (categoryNumber==5) categoryCollect.add("양식")
        }
        return categoryCollect
    }

    fun menuRecommend(){ // 카테고리 내 못먹는 음식과 비교하여 랜덤으로 아무거나 추천

    }

}