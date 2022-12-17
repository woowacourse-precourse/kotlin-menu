package menu.data

sealed class Error {
    data class NameLengthError(val message: String): Error()

    companion object {
        const val ERROR_HEADER = "[ERROR] "
        const val ERROR_NAME_LENGTH = "코치의 이름은 2글자 이상 4글자 이하로 입력해야 합니다."
        const val ERROR_MEMBER_NUMBERS= "코치는 최소 2명 이상 5명 이하로 입력해야 합니다."
        const val ERROR_FOOD_NOT_IN_MENUS = "못 먹는 메뉴는 카테고리 별 음식 리스트에 있는 메뉴여야 합니다."
        const val ERROR_FOOD_SIZE = "못 먹는 메뉴는 0개 이상 2개 이하여야 합니다."
    }
}
