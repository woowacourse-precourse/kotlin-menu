package menu

enum class MenuCategory(val koreanName: String, val menus: List<String>) {
    JAPANESE("일식", listOf("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREAN("한식", listOf("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINESE("중식", listOf("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIAN("아시안", listOf("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WESTERN("양식", listOf("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    companion object {
        private val JAPANESE_FOOD = listOf("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")
        private val KOREAN_FOOD = listOf("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")
        private val CHINESE_FOOD = listOf("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")
        private val ASIAN_FOOD = listOf("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "'반미", "월남쌈", "분짜")
        private val WESTERN_FOOD = listOf("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")
        private const val RANDOM_SHOULD_IN_ONE_TO_FIVE = "[ERROR] 랜덤 생성 번호는 1에서 5 사이여야 합니다."
        private const val ONE = 1
        fun judgeMenuCategory(randomNumber: Int): MenuCategory {
            return values().find { it.ordinal == randomNumber - ONE }!!
        }
    }
}
