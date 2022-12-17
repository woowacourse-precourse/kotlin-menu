package menu.values

// notice
const val NOTICE_SERVICE_START_MESSAGE = "점심 메뉴 추천을 시작합니다."
const val NOTICE_SERVICE_END_MESSAGE = "메뉴 추천 결과입니다."
const val NOTICE_RECOMMEND_SUCCESS_MESSAGE = "추천을 완료했습니다."

// require
const val REQUIRE_COACHES_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)"
const val REQUIRE_COACH_CANT_EAT_MENUS_MESSAGE = "%s(이)가 못 먹는 메뉴를 입력해 주세요."

// value condition
const val RECOMMEND_COACHES_CONDITION_MESSAGE = "코치는 ${MIN_COACHES_NUMBER}명 이상, ${MAX_COACHES_NUMBER}명 이하로 입력해야 합니다."
const val RECOMMEND_COACH_NAME_CONDITION_MESSAGE = "코치의 이름은 ${MIN_COACH_NAME_LENGTH}자 이상, ${MAX_COACH_NAME_LENGTH}명 이하로 입력해야 합니다."
const val RECOMMEND_CANT_EAT_MENUS_CONDITION_MESSAGE = "코치가 못 먹는 메뉴들은 ${MIN_COACH_CANT_EAT_MENU_NUMBER}개 이상, ${MAX_COACH_CANT_EAT_MENU_NUMBER}개 이하로 입력해야 합니다."

// error
const val ERROR_MESSAGE = "[ERROR] "