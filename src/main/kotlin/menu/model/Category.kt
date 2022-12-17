package menu.model

import camp.nextstep.edu.missionutils.Randoms

class Category() {
    private val randomCategories = listOf("일식","한식","중식","아시안","양식").get(Randoms.pickNumberInRange(1, 5)-1)

    fun getCategoryFood():String {
        var food = ""
        when (randomCategories) {
            "일식" -> food = "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼".split(", ").shuffled()[0]
            "한식" -> food = "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음".split(", ").shuffled()[0]
            "중식" -> food = "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채".split(", ").shuffled()[0]
            "아시안" -> food = "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜".split(", ").shuffled()[0]
            "양식" -> food = "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니".split(", ").shuffled()[0]
        }
        return food
    }

    fun getRandomCategories() = randomCategories
}