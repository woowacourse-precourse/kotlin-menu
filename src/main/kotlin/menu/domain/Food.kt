package menu.domain

import camp.nextstep.edu.missionutils.Randoms
import menu.constant.Constant

class Food {
    private val japanFood = listOf("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")
    private val koreaFood = listOf("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")
    private val chinaFood = listOf("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")
    private val asiaFood = listOf("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")
    private val westernFood = listOf("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")

    fun recommendFood(category: String): String {
        return when (category) {
            Constant.KOREAN_FOOD -> pickRandomFood(koreaFood)
            Constant.WESTERN_FOOD -> pickRandomFood(westernFood)
            Constant.CHINESE_FOOD -> pickRandomFood(chinaFood)
            Constant.JAPANESE_FOOD -> pickRandomFood(japanFood)
            Constant.ASIAN_FOOD -> pickRandomFood(asiaFood)
            else -> ""
        }
    }

    private fun pickRandomFood(menus: List<String>): String {
        return Randoms.shuffle(menus)[0]
    }
}