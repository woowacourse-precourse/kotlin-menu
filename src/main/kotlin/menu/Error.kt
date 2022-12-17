package menu

enum class Error(val message: String) {
    ERROR_COACH_PERSON_NUM_WRONG("코치의 이름은 2명 이상 5명 이하여야 합니다.\n"),
    ERROR_COACH_NAME_WRONG("코치의 이름은 2글자 이상 4글자 이하여야 합니다.\n"),

}