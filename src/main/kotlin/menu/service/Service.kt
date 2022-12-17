package menu.Service

import camp.nextstep.edu.missionutils.Randoms
import menu.view.OutputView

class Service {
    fun startService(cantEatMenu: Map<String, List<String>>, category: List<String>) {
        val coachName = cantEatMenu.keys.toList()
        val menus = cantEatMenu.values.toList()
        var result: MutableList<String>
        for(i in coachName.indices) {
            result = menuRecommandService(coachName[i], menus[i], category, i)
            OutputView().printCoachMenu(result)
        }

    }
    fun menuRecommandService(coachName: String, menus: List<String>, category: List<String>, index: Int): MutableList<String> {
        var result = mutableListOf<String>()
        result.add(0, coachName)
        var menu: String
        var count = 1
        while(count < 6) {
            menu = recommandMenu(category[count])
            if(menus.contains(menu)){
                continue
            } else {
                result.add(count, menu)
                count++
            }
        }
        return result
    }

    fun createRandomCategory(): MutableList<String> {
        val categories: List<String> = listOf("","일식", "한식", "중식", "아시안", "양식")
        var result = mutableListOf<String>("카테고리")
        var count = 1
        var category: String
        while(count < 6) {
            var randomNum = Randoms.pickNumberInRange(1, 5)
            if(randomNum == 0) {
                continue
            } else if(randomNum != 0) {
                category = categories.get(randomNum)
                result.add(count, category)
                count++
            }
        }
        return result
    }
    fun recommandMenu(category: String): String {
        var menus: List<String> = when (category) {
            "일식" -> listOf("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")
            "한식" -> listOf("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")
            "중식" -> listOf("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")
            "아시안" -> listOf("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")
            "양식" -> listOf("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")
            else -> throw IllegalArgumentException()
        }
        return Randoms.shuffle(menus)[0]
    }

}