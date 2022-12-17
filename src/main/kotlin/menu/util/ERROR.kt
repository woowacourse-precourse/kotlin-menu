package menu.util

object ERROR {
    const val ERR = "[ERROR] "
    const val COACH_NAME_LENGTH = ERR.plus("코치의 이름은 2글자 이상 4글자 이하로 작성해 주세요.")
    const val DUPLICATED_FOOD = ERR.plus("해당 음식은 이미 입력됬습니다.")
    const val COACH_MAX_INEDIBLE_LENGTH = ERR.plus("금식은 최대 2개까지 입니다.")
    const val DUPLICATED_COACH_NAME = ERR.plus("코치 이름은 중복되면 안됩니다.")
    const val COACH_COUNT_LENGHT = ERR.plus("코치는 최소 2명, 최대 5명 입니다.")

    const val WROGN_CATEGORY_NUMBER = ERR.plus("잘못된 카테고리 번호입니다.")
    const val NOT_EXIST_FOOD = ERR.plus("그런 음식 이름은 존재하지 않습니다.")
    const val WRONG_NUMBER_WEEKDAY = ERR.plus("월, 화, 수, 목, 금 5일으로 이루어진 카테고리를 입력해 주세요.")
    const val MAXIMUN_DIET_LENGTH = ERR.plus("평일 식단을 초과하여 작성 중입니다.")
    const val DUPLICATED_WEEK = ERR.plus("똑같은 요일이 2번 입력됬습니다.")
}
