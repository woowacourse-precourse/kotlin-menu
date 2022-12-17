package menu.domain

import camp.nextstep.edu.missionutils.Randoms

enum class MenuCategory(
    private val categoryName: String,
    private val menus: List<String>,
) {
    JAPAN("일식", listOf("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREA("한식", listOf("김치찌개", "김밥", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINA("중식", listOf("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIAN("아시안", listOf("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WESTERN("양식", listOf("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    fun getRandomFood(inedibleFoods: List<String>): String {
        var randomFood = Randoms.shuffle(menus)[0]
        while (inedibleFoods.contains(randomFood)) {
            randomFood = Randoms.shuffle(menus)[0]
        }
        return randomFood
    }

    companion object {
        fun convert(category: String): MenuCategory? = when (category) {
            "일식" -> JAPAN
            "한식" -> KOREA
            "중식" -> CHINA
            "아시안" -> ASIAN
            "양식" -> WESTERN
            else -> null
        }

        fun getAllCategory(): List<MenuCategory> = listOf(JAPAN, KOREA, CHINA, ASIAN, WESTERN)

        fun getAllCategoryAsString(): List<String> = listOf("", "일식", "한식", "중식", "아시안", "양식")
    }
}