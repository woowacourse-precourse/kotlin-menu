package menu

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class StartRecommend {
    fun gameStart() {
        println("점심 메뉴 추천을 시작합니다.")

        println()
        println("코치의 이름을 입력해 주세요. (, 로 구분)")
        var input = Console.readLine()
        val user = input.split(",")

        // 코치 숫자 예외처리
        if(user.size < 2 || user.size > 5){
            throw IllegalArgumentException("[ERROR]코치는 최소 2명 최대 5명이 같이 식사를 할 수 있습니다.")
        }

        // 코치 이름 예외처리
        for (i in user.indices) {
            if(user[i].length < 2 || user[i].length > 4){
                throw IllegalArgumentException("[ERROR]이름 형식에 맞춰주세요(이름은 2글자에서 4글자).")
            }
        }

        println()

        // 못 먹는 메뉴 담는 배열
        var avoid = mutableListOf<MutableList<String>>()

        for (i in 0 until user.size) {
            println(user[i] + "(이)가 못 먹는 메뉴를 입력해 주세요.")
            var menu = Console.readLine()
            if(menu == null) {
                continue
            }
            if (menu.contains(",")){
                var cantEat = menu.split(",")
                avoid.add(cantEat as MutableList<String>)
                continue
            }
            avoid.add(menu as MutableList<String>)
        }

        println(avoid)

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

        // 음식 리스트
        val japan: MutableList<String> = mutableListOf("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")
        val korea: MutableList<String> = mutableListOf("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")
        val china: MutableList<String> = mutableListOf("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")
        val asian: MutableList<String> = mutableListOf("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")
        val western: MutableList<String> = mutableListOf("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")

        // 식단 짜주기
        for (idx in 0 until user.size) {
            print("[ " + user[idx])
            var i = 0
            while (i < diet.size){
                if (diet[i] == "일식") {
                    val menu: String = Randoms.shuffle(japan)[0]
                    print(" | ")
                    print(menu)
                } else if (diet[i] == "한식") {
                    val menu: String = Randoms.shuffle(korea)[0]
                    print(" | ")
                    print(menu)
                } else if (diet[i] == "중식") {
                    val menu: String = Randoms.shuffle(china)[0]
                    print(" | ")
                    print(menu)
                } else if (diet[i] == "아시안") {
                    val menu: String = Randoms.shuffle(asian)[0]
                    print(" | ")
                    print(menu)
                } else if (diet[i] == "양식") {
                    val menu: String = Randoms.shuffle(western)[0]
                    print(" | ")
                    print(menu)
                }
                i++
            }
            println(" ]")
        }

        println()
        println("추천을 완료했습니다.")

    }
}