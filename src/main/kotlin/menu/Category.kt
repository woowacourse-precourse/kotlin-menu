package menu

import camp.nextstep.edu.missionutils.Randoms
import java.util.*

class Category {
    var japan = mutableListOf("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")
    var korea = mutableListOf("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")
    var china = mutableListOf("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")
    var asian = mutableListOf("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")
    var west = mutableListOf("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")

    fun recommendCategory(weekCategory: MutableList<String>) : MutableList<String>{
        while (true){
            var categories = mutableListOf("", "일식", "한식", "중식", "아시안", "양식")
            val category: String = categories.get(Randoms.pickNumberInRange(1, 5))
            if (duplicationCategory(weekCategory, category) == 1){
                weekCategory.add(category)
                break
            }
        }
        return weekCategory
    }

    fun duplicationCategory(weekCategory: MutableList<String>, category: String) : Int{
        val count = Collections.frequency(weekCategory, category)
        if (count != 2) return 1
        return 0
    }

    fun coachJapanMenu(coaches : MutableList<Coach>) : MutableList<Coach>{
        for (i in coaches){
            var menus = japan
            recommendMenu(i, menus)
        }
        return coaches
    }
    fun coachKoreaMenu(coaches : MutableList<Coach>) : MutableList<Coach>{
        for (i in coaches){
            var menus = korea
            recommendMenu(i, menus)
        }
        return coaches
    }
    fun coachChinaMenu(coaches : MutableList<Coach>) : MutableList<Coach>{
        for (i in coaches){
            var menus = china
            recommendMenu(i, menus)
        }
        return coaches
    }
    fun coachAsianMenu(coaches : MutableList<Coach>) : MutableList<Coach>{
        for (i in coaches){
            var menus = asian
            recommendMenu(i, menus)
        }
        return coaches
    }
    fun coachWestMenu(coaches : MutableList<Coach>) : MutableList<Coach>{
        for (i in coaches){
            var menus = west
            recommendMenu(i, menus)
        }
        return coaches
    }

    private fun recommendMenu(i: Coach, menus: MutableList<String>){
        while (true){
            val menu: String = Randoms.shuffle(menus)[0]
            if (!i.hateFood.contains(menu) && !i.menu.contains(menu)){
                i.menu.add(menu)
                break
            }
            if (i.hateFood.contains(menu) && i.menu.contains(menu)) continue
        }
    }
}