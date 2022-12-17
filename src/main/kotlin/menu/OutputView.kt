package menu

class OutputView {
    fun menuSuggestionStart() = println(MENU_SUGGESTION_START)


    companion object {
        private const val MENU_SUGGESTION_START = "점심 메뉴 추천을 시작합니다.\n"
    }
}