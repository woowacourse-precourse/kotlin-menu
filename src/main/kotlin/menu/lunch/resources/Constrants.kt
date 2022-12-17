package menu.lunch.resources

// FOR MENU RECOMMEND LOGIC
const val JAPANESE_FOOD_CATEGORY = "일식"
const val KOREAN_FOOD_CATEGORY = "한식"
const val CHINESE_FOOD_CATEGORY = "중식"
const val ASIAN_FOOD_CATEGORY = "아시안"
const val WESTERN_FOOD_CATEGORY = "양식"

val KOREAN_FOOD_MENU = listOf("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")
val JAPANESE_FOOD_MENU = listOf("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")
val CHINESE_FOOD_MENU = listOf("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")
val WESTERN_FOOD_MENU = listOf("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")
val ASIAN_FOOD_MENU = listOf("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")

// FOR OUTPUT VIEW
const val OUTPUT_START_MESSAGE = "점심 메뉴 추천을 시작합니다."
const val OUTPUT_RECOMMEND_RESULT_PRE_MESSAGE = "메뉴 추천 결과입니다."
const val OUTPUT_DAY_OF_THE_WEEK = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"
const val OUTPUT_CATEGORY_LIST = "[ 카테고리 | %s ]"
const val OUTPUT_END_MESSAGE = "추천을 완료했습니다."
const val OUTPUT_COACH_LIST = "[ %s | %s ]"

// FOR INPUT VIEW
const val INPUT_NAME_OF_COACHES = "코치의 이름을 입력해 주세요. (, 로 구분)"
const val INPUT_DISLIKE_MENU = "%s(이)가 못 먹는 메뉴를 입력해 주세요."

// FOR ERROR MESSAGE
private const val ERROR_MESSAGE_PREFIX = "[ERROR] "
const val ERROR_INPUT_AT_LEAST_TWO = ERROR_MESSAGE_PREFIX + "코치는 최소 2명 이상 입력해야 합니다."
const val ERROR_INPUT_AT_MOST_FIVE = ERROR_MESSAGE_PREFIX + "코치는 최소 5명 이하 입력해야 합니다."
const val ERROR_INPUT_AT_MOST_TWO = ERROR_MESSAGE_PREFIX + "못 먹는 메뉴는 최대 2개까지 입력할 수 있습니다."
