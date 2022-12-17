package menu.data

object Message {
    const val MSG_START = "점심 메뉴 추천을 시작합니다."
    const val MSG_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)"
    const val MSG_DECLINE_MENU = "NAME(이)가 못 먹는 메뉴를 입력해 주세요."
    const val MSG_MENU_RESULT = "메뉴 추천 결과입니다."
    const val MSG_END = "추천을 완료했습니다."
    const val MSG_WEEK = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"

    const val ERR_COACH_MORE_THAN_TWO = "코치는 최소 2명 이상 입력해야 합니다."
    const val ERR_COACH_LESS_THAN_FIVE = "코치는 최대 5명 이하 입력해야 합니다."
    const val ERR_COACH_NAME_MORE_THAN_TWO = "코치의 이름은 2글자 이상이어야 합니다."
    const val ERR_COACH_NAME_LESS_THAN_FOUR = "코치의 이름은 4글자 이하여야 합니다."
    const val ERR_COACH_COMMA = "코치의 이름을 ,로 구별해 주세요."
    const val ERR_DECLINE_MENU_LESS_THAN_TWO = "못 먹는 메뉴는 최대 2개까지 입력가능합니다."
    const val ERR_DECLINE_MENU_COMMA = "못 먹는 메뉴를 ,로 구별해 주세요."
    const val ERR_MENU_ARGUMENT = "메뉴 생성에 필요한 인자가 불충분합니다."
}