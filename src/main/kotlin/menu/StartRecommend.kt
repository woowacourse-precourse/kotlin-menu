package menu

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class StartRecommend {
    fun gameStart(){
        println("점심 메뉴 추천을 시작합니다.")

        println()
        println("코치의 이름을 입력해 주세요. (, 로 구분)")
        var input = Console.readLine()
        val user = input.split(",")

        println()
        for(i in user.indices){
            println(user[i] + "(이)가 못 먹는 메뉴를 입력해 주세요.")
            var menu = Console.readLine()
            println()
        }

        println("메뉴 추천 결과입니다.")
        println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]")


//        일식: 규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼
//        한식: 김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음
//        중식: 깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채
//        아시안: 팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜
//        양식: 라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니

        // 1이면 일식, 2면 한식, 3이면 중식, 4면 아시안, 5면 양식
        val categories : MutableList<String> = mutableListOf("", "일식", "한식", "중식", "아시안", "양식")

        // [ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]
        print("[ 카테고리")
        for(i in 0 until 5){
            val category: String = categories.get(Randoms.pickNumberInRange(1, 5))
            print(" | ")
            print(category)
        }
        println(" ]")

    }
}