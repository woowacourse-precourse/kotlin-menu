package menu.constants

// 기준 숫자
const val MINIMUM_COACH_COUNT = 2
const val MAXIMUM_COACH_COUNT = 5

const val MINIMUM_NAME_LENGTH = 2
const val MAXIMUM_NAME_LENGTH = 4

const val MAXIMUM_DUPLICATE_CATEGORY_COUNT = 2


// 출력 문구
const val START_MENT = "점심 메뉴 추천을 시작합니다."
const val INPUT_COACH_NAMES_MENT = "코치의 이름을 입력해 주세요. (, 로 구분)"
const val INPUT_CANT_EAT_MENU_MENT = "%s(이)가 못 먹는 메뉴를 입력해 주세요."


//에러 문구
const val ERROR_PREFIX = "[ERROR]"
const val ERROR_NAMES_SIZE = "$ERROR_PREFIX 코치는 최소 2명 이상 최대 5명 이하 입력해야 합니다."
const val ERROR_NAMES_LENGTH = "$ERROR_PREFIX 코치 이름은 최소 2글자 최대 4글자 입니다."
const val ERROR_CANT_EAT_MENUS_SIZE = "$ERROR_PREFIX 못먹는 메뉴는 최대 2개 입니다."


// 결과 출력 문구
const val RESULT_MENT = "메뉴 추천 결과입니다."
const val RESULT_HEADER = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"
const val RESULT_CATEGORY = "[ 카테고리 | %s | %s | %s | %s | %s ]"
const val RESULT_COACH_MENU = "[ %s | %s | %s | %s | %s | %s ]"
const val RESULT_SUCCESS_MENT = "추천을 완료했습니다."