package menu.data

object Menu {
    const val JAPANESE_FOODS = "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼"
    const val KOREAN_FOODS = "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음"
    const val CHINESE_FOODS = "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채"
    const val ASIAN_FOODS = "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜"
    const val WESTERN_FOODS = "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니"

    const val JAPANESE_CATEGORY = "일식"
    const val KOREAN_CATEGORY = "한식"
    const val CHINESE_CATEGORY = "중식"
    const val ASIAN_CATEGORY = "아시안"
    const val WESTERN_CATEGORY = "양식"

    val japaneseFoods = separateFoods(JAPANESE_FOODS)
    val koreanFoods = separateFoods(KOREAN_FOODS)
    val chineseFoods = separateFoods(CHINESE_FOODS)
    val asianFoods = separateFoods(ASIAN_FOODS)
    val westernFoods = separateFoods(WESTERN_FOODS)
    val allFoods = japaneseFoods + koreanFoods + chineseFoods + asianFoods + westernFoods

    private fun separateFoods(foods: String): List<String> {
        return foods.split(", ")
    }
}