package menu

import camp.nextstep.edu.missionutils.Randoms

class Menu {
    var CT=categories()

    fun categorySelect(): List<String>{
        var categoryCollect= mutableListOf<String>()
        var categoryNumberCollect= mutableListOf<String>()
        while (true){
            if (categoryNumberCollect.size==5) break
            val categoryNumber: Int = Randoms.pickNumberInRange(1, 5)
            if (categoryNumberCollect.count { it == categoryNumber.toString() }==2) continue
            categoryNumberCollect.add(categoryNumber.toString())
            if (categoryNumber==1) categoryCollect.add("일식")
            if (categoryNumber==2) categoryCollect.add("한식")
            if (categoryNumber==3) categoryCollect.add("중식")
            if (categoryNumber==4) categoryCollect.add("아시안")
            if (categoryNumber==5) categoryCollect.add("양식")
        }
        return categoryCollect
    }

    fun menuRecommend(categorieName: String): String{
        var menu=""
        if (categorieName=="일식") menu=Randoms.shuffle(CT.Japanese)[0]
        if (categorieName=="한식") menu=Randoms.shuffle(CT.Korean)[0]
        if (categorieName=="중식") menu=Randoms.shuffle(CT.Chinese)[0]
        if (categorieName=="아시안") menu=Randoms.shuffle(CT.Asian)[0]
        if (categorieName=="양식") menu=Randoms.shuffle(CT.Western)[0]
        return menu
    }

}