package menu.values

object ErrorMessage {
    private const val ERROR = "[ERROR] "
    const val COACH_NUMBER_ERROR = ERROR.plus("코치는 2명 이상 5명 이하입니다.")
    const val COACH_NAME_ERROR = ERROR.plus("코치 이름은 2글자 이상 4글자 이하")

    const val MENU_RANGE_ERROR  = ERROR.plus("메뉴는 0개 이상 2개 이하")
}