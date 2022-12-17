package menu

class OutputView {
    fun printRecommendMenuStart() {
    }

    fun printCoachCantEatMenu() {
    }

    fun printResult() {
    }

    companion object {
        private const val MENU_START = "점심 메뉴 추천을 시작합니다."
        private const val ENTER_COACHES_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)"
        private const val MENU_COACH_CANT_EAT = "(이)가 못 먹는 메뉴를 입력해 주세요."
        private const val MENU_RECOMMEND_RESULT = "메뉴 추천 결과입니다.\n"
        private const val MENU_RECOMMEND_END = "추천을 완료했습니다."
    }
}
