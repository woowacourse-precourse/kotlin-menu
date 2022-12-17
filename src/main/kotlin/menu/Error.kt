package menu

enum class Error(val message: String) {
    ERROR_COACH_PERSON_NUM_WRONG("\n[ERROR] 코치의 이름은 2명 이상 5명 이하여야 합니다."),
    ERROR_COACH_NAME_WRONG("\n[ERROR] 코치의 이름은 2글자 이상 4글자 이하여야 합니다."),
    ERROR_HATE_MENU_MAX_TWO("\n[ERROR] 코치가 못 먹는 메뉴는 최대 두 개입니다."),
    ERROR_DUPLICATE_COACH_NAME("\n[ERROR] 코치의 이름에 중복이 있으면 안됩니다."),
    ERROR_HATE_MENU_DUPLICATE("\n[ERROR] 메뉴에는 중복이 있으면 안됩니다."),
}