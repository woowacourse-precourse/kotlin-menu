package menu.strings

object Message {
    enum class PrintMessage(val msg: String) {
        PRINT_RECOMMEND("점심 메뉴 추천을 시작합니다."),
        GET_COACH_NAME("코치의 이름을 입력해 주세요. (, 로 구분)"),
        GET_UNAVAILABLE_FOOD("%s(이)가 못 먹는 메뉴를 입력해 주세요."),
        PRINT_RESULT("메뉴 추천 결과입니다."),
        DAYS("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"),
        CATEGORY("[ 카테고리 | %s | %s | %s | %s | %s ]"),
        RECOMMEND_FOOD("[ %s | %s | %s | %s | %s | %s ]"),
        PRINT_END("추천을 완료했습니다.")
    }

    enum class Country(val value: String){
        JAPAN("일식"),
        KOREAN("한식"),
        CHINA("중식"),
        ASIAN("아시안"),
        WESTERN("양식");
    }
}