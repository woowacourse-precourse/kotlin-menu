package menu.strings

enum class MenuErrorMessage(val message: String) {
    INVALID_NAME_LENGTH("[ERROR] 이름 길이는 최소 2글자, 최대 4글자로 입력해야 합니다."),
    INVALID_COACH_COUNT("[ERROR] 코치의 수를 최소 2명, 최대 5명까지 입력해야 합니다."),
    INVALID_CATEGORY_NAME("[ERROR] 추천할 수 없는 카테고리");
}