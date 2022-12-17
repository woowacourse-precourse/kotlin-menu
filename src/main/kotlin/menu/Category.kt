package menu

import camp.nextstep.edu.missionutils.Randoms
import java.util.*


class Category {
    //메뉴
    var japan = mutableListOf("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")
    var korea = mutableListOf("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")
    var china = mutableListOf("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")
    var asian = mutableListOf("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")
    var west = mutableListOf("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")

    fun recommandCategory() : MutableList<String>{
        var weekCategory = mutableListOf<String>()
        while (weekCategory.size != 5){
            var categories = mutableListOf("", "일식", "한식", "중식", "아시안", "양식")
            val category: String = categories.get(Randoms.pickNumberInRange(1, 5))

            //3번 이상 같은 카테고리면 X
            val count = Collections.frequency(weekCategory, category)
            if (count != 2) weekCategory.add(category)
        }
        return weekCategory
    }

    fun coachMenu(coach: Coach, weekCategory: MutableList<String>) : MutableList<String>{
        var coachMenu = mutableListOf<String>()
        for (i in weekCategory){
            if (i == "일식"){
                var menus = japan
                while (true){
                    val menu: String = Randoms.shuffle(menus)[0]
                    //중복메뉴, 먹지 못하는 음식 추전 X
                    if (!coach.hateFood.contains(menu) && !coach.menu.contains(menu)){
                        coachMenu.add(menu)
                        break
                    }
                }
            }
            if (i == "한식"){
                var menus = korea
                while (true){
                    val menu: String = Randoms.shuffle(menus)[0]
                    //중복메뉴, 먹지 못하는 음식 추전 X
                    if (!coach.hateFood.contains(menu) && !coach.menu.contains(menu)){
                        coachMenu.add(menu)
                        break
                    }
                }
            }
            if (i == "중식"){
                var menus = china
                while (true){
                    val menu: String = Randoms.shuffle(menus)[0]
                    //중복메뉴, 먹지 못하는 음식 추전 X
                    if (!coach.hateFood.contains(menu) && !coach.menu.contains(menu)){
                        coachMenu.add(menu)
                        break
                    }
                }
            }
            if (i == "아시안"){
                var menus = asian
                while (true){
                    val menu: String = Randoms.shuffle(menus)[0]
                    //중복메뉴, 먹지 못하는 음식 추전 X
                    if (!coach.hateFood.contains(menu) && !coach.menu.contains(menu)){
                        coachMenu.add(menu)
                        break
                    }
                }
            }
            if (i == "양식"){
                var menus = west
                while (true){
                    val menu: String = Randoms.shuffle(menus)[0]
                    //중복메뉴, 먹지 못하는 음식 추전 X
                    if (!coach.hateFood.contains(menu) && !coach.menu.contains(menu)){
                        coachMenu.add(menu)
                        break
                    }
                }
            }
        }
        return coachMenu
    }
}