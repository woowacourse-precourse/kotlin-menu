package menu

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class StartRecommend {

    private val japan: MutableList<String> = mutableListOf("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")
    private val korea: MutableList<String> = mutableListOf("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")
    private val china: MutableList<String> = mutableListOf("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")
    private val asian: MutableList<String> = mutableListOf("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")
    private val western: MutableList<String> = mutableListOf("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")
    fun gameStart() {
        val inputView = InputView()
        val user = inputView.inputCoach()

        // 못 먹는 음식
        val avoid = inputView.inputCantEatMenu(user as MutableList<String>)

        val outputVIew = OutputVIew()
        // 월화수목금, 요일별 음식장르 추천
        val diet = outputVIew.showMenu()

        // 음식 리스트
        foodForCoach(user, diet, avoid)

        println()
        println("추천을 완료했습니다.")
    }

    private fun foodForCoach(user: List<String>, diet: MutableList<String>, avoid: MutableList<MutableList<String>>) {

        // 식단 짜주기
        for (idx in user.indices) {
            print("[ " + user[idx])
            var i = 0
            while (i < diet.size) {
                if (diet[i] == "일식") {
                    printFood(japan, avoid, idx)
                } else if (diet[i] == "한식") {
                    printFood(korea, avoid, idx)
                } else if (diet[i] == "중식") {
                    printFood(china, avoid, idx)
                } else if (diet[i] == "아시안") {
                    printFood(asian, avoid, idx)
                } else if (diet[i] == "양식") {
                    printFood(western, avoid, idx)
                }
                i++
            }
            println(" ]")
        }
    }

    fun printFood(food: MutableList<String>, avoid: MutableList<MutableList<String>>, idx: Int) {
        while (true) {
            val menu: String = Randoms.shuffle(food)[0]
            if (!avoid[idx].contains(menu)) {
                print(" | ")
                print(menu)
                break
            }
        }
    }
}