package menu

object FoodData {
    val categories = mapOf(1 to "일식", 2 to "한식", 3 to "중식", 4 to "아시안", 5 to "양식")

    private val allMenus = listOf(
        "규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼",
        "김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음",
        "깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채",
        "팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜",
        "라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"
    )

    /**
     * menu는 List<String>의 형태
     */
    private val japaneseMenus = listOf("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")
    private val koreanMenus = listOf("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")
    private val chineseMenus = listOf("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")
    private val asianMenus = listOf("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")
    private val westernMenus = listOf("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")

    fun Int.categoryToMenus(): List<String> {
        return when (this) {
            1 -> japaneseMenus
            2 -> koreanMenus
            3 -> chineseMenus
            4 -> asianMenus
            5 -> westernMenus
            else -> listOf()
        }
    }

    fun isInMenus(menu: String): Boolean {
        allMenus.forEach { eachMenus ->
            if (eachMenus.contains(menu)) {
                return true
            }
        }
        return false
    }
}
