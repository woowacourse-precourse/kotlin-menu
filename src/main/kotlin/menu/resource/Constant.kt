package menu.resource

// FOR INPUT VIEW
const val MENU_START = "점심 메뉴 추천을 시작합니다."
const val INPUT_COACH = "\n코치의 이름을 입력해 주세요. (, 로 구분)"
const val INPUT_FOOD = "\n%s(이)가 못 먹는 메뉴를 입력해 주세요."

// FOR OUTPUT VIEW
const val RECOMMEND_RESULT = "\n메뉴 추천 결과입니다."
const val RECOMMEND_END = "\n추천을 완료했습니다."

// FOR FOOD
val FOOD_JAPAN = listOf<String>("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")
val FOOD_KOREA = listOf<String>("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")
val FOOD_CHINA = listOf<String>("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")
val FOOD_ASIA = listOf<String>("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")
val FOOD_USA = listOf<String>("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")
val FOOD_ALL = FOOD_ASIA + FOOD_CHINA + FOOD_KOREA + FOOD_JAPAN + FOOD_USA

// FOR LOGIC
const val MIN_RANGE_COACH_NUMBER = 2
const val MAX_RANGE_COACH_NUMBER = 5
const val MIN_RANGE_COACH_NAME_LENGTH = 2
const val MAX_RANGE_COACH_NAME_LENGTH = 4
const val MIN_RANGE_FOOD_NUMBER = 0
const val MAX_RANGE_FOOD_NUMBER = 2


// FOR ERROR HANDLING
private const val ERROR_MESSAGE_PREFIX = "[ERROR] "
const val ERROR_INPUT_COACH = ERROR_MESSAGE_PREFIX + "올바른 형태의 코치의 수와 코치의 이름을 입력해주세요."
const val ERROR_INPUT_FOOD = ERROR_MESSAGE_PREFIX + "올바른 형태의 음식의 수와 메뉴에 존재하는 음식을 입력해주세요."
