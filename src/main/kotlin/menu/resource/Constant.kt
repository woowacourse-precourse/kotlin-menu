package menu.resource

// FOR INPUT VIEW

const val MENU_START = "점심 메뉴 추천을 시작합니다."
const val INPUT_COACH = "\n코치의 이름을 입력해 주세요. (, 로 구분)"
const val INPUT_FOOD = "\n%s(이)가 못 먹는 메뉴를 입력해 주세요."

// FOR OUTPUT VIEW
const val RECOMMEND_RESULT = "\n메뉴 추천 결과입니다."
const val RECOMMEND_END = "\n추천을 완료했습니다."


// FOR LOGIC
const val MIN_RANGE_COACH_NUMBER = 2
const val MAX_RANGE_COACH_NUMBER = 5
const val MIN_RANGE_COACH_NAME_LENGTH = 2
const val MAX_RANGE_COACH_NAME_LENGTH = 4

// FOR ERROR HANDLING
private const val ERROR_MESSAGE_PREFIX = "[ERROR] "
const val ERROR_INPUT_COACH = ERROR_MESSAGE_PREFIX + "올바른 형태의 코치의 수와 코치의 이름을 입력해주세요."
