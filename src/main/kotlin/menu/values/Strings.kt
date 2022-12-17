package menu.values

enum class Strings(val message: String) {
    START("점심 메뉴 추천을 시작합니다."),
    INPUT_NAME("코치의 이름을 입력해 주세요. (, 로 구분)"),
    INPUT_HATEFOOD("(이)가 못 먹는 메뉴를 입력해 주세요."),
    RESULT("메뉴 추천 결과입니다."),
    COMPLETE("추천을 완료했습니다."),


    DAY("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"),


    INPUT_NAME_ERROR("[ERROR] 코치의 이름은 최소 2글자 최대 4글자 입니다."),
    INPUT_GROUP_ERROR("[ERROR] 코치는 최소 2명에서 5명입니다.")

}