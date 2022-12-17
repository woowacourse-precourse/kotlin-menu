package menu

const val JAPANESE_TEXT = "일식"
const val KOREAN_TEXT = "한식"
const val CHINESE_TEXT = "중식"
const val ASIAN_TEXT = "아시안"
const val WESTERN_TEXT = "양식"

const val JAPANESE_NUMBER = 1
const val KOREAN_NUMBER = 2
const val CHINESE_NUMBER = 3
const val ASIAN_NUMBER = 4
const val WESTERN_NUMBER = 5

const val WEEK_NUMBER = 5
val WEEKS = listOf("월요일", "화요일", "수요일", "목요일", "금요일")

val AVAILABLE_MENUS = """
$JAPANESE_TEXT: 규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼
$KOREAN_TEXT: 김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음
$CHINESE_TEXT: 깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채
$ASIAN_TEXT: 팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜
$WESTERN_TEXT: 라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니
""".trimIndent().trim()
