package menu.util

const val PREFIX = "[ "
const val SEPARATOR = " | "
const val POSTFIX = " ]"
const val MAX_DAY = 5
const val MIN_NOT_EAT = 0
const val MAX_NOT_EAT = 2
const val MIN_COACH_SIZE = 2
const val MAX_COACH_SIZE = 5
const val MIN_NAME_SIZE = 2
const val MAX_NAME_SIZE = 4
const val CATEGORY = "카테고리"
const val JAPAN = "일식"
const val KOREAN = "한식"
const val CHINESE = "중식"
const val ASIAN = "아시안"
const val AMERICA = "양식"
const val JAPAN_MENUS = "규동,우동,미소시루,스시,가츠동,오니기리,하이라이스,라멘,오코노미야끼"
const val KOREAN_MENUS = "김밥,김치찌개,쌈밥,된장찌개,비빔밥,칼국수,불고기,떡볶이,제육볶음"
const val CHINESE_MENUS = "깐풍기,볶음면,동파육,짜장면,짬뽕,마파두부,탕수육,토마토 달걀볶음,고추잡채"
const val ASIAN_MENUS = "팟타이,카오 팟,나시고렝,파인애플 볶음밥,쌀국수,똠얌꿍,반미,월남쌈,분짜"
const val AMERICA_MENUS = "라자냐,그라탱,뇨끼,끼슈,프렌치 토스트,바게트,스파게티,피자,파니니"

const val INPUT_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)"
const val INPUT_COACH_NOT_EAT = "(이)가 못 먹는 메뉴를 입력해 주세요."
const val RESULT_MESSAGE = "메뉴 추천 결과입니다."
const val DIVISION_MESSAGE = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"

const val ERROR_HEADER = "[ERROR] "
const val ERROR_COACH_NAME_LENGTH = "코치의 이름은 최소 2글자, 최대 4글자입니다."
const val ERROR_COACH_SIZE = "코치는 최소 2명 이상 5명 이하로 입력해야 합니다."
const val ERROR_INVALID_MENU = "카테고리에 없는 메뉴입니다."
const val ERROR_NOT_EAT_SIZE = "못먹는 음식은 0개에서 2개이하로 입력해야 합니다."
const val ERROR_CATEGORY_NUMBER = "잘못된 카테고리 번호입니다."