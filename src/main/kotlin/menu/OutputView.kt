package menu

class OutputView {

    fun printBlank() {
        println()
    }

    fun printRecommendMenuStart() {
        println(MENU_START)
        printBlank()
        println(ENTER_COACHES_NAME)
    }

    fun printCoachCantEatMenu(coachName: String) {
        println("$coachName$MENU_COACH_CANT_EAT")
    }

    fun printResult(coachesName: List<String>, menuCategory: List<MenuCategory>, menuFromCategory: List<List<String>>) {
        println(MENU_RECOMMEND_RESULT)
        println(DAY_OF_THE_WEEK)
        val koreanCategory = mutableListOf<String>()
        for (category in menuCategory) {
            koreanCategory.add(category.koreanName)
        }
        println("[ 카테고리 | ${koreanCategory.joinToString(separator = DIVISION_LINE)} ]")
        var i = 0
        for (element in menuFromCategory.indices) {
            print("[ ${coachesName[element]} | ")
            repeat(4) {
                print("${menuFromCategory[element][i]} | ")
                i++
            }
            repeat(1) {
                print("${menuFromCategory[element][i]} ]")
                i++
            }
            println()
        }

        printBlank()
        println(MENU_RECOMMEND_FINISH)
    }

    companion object {
        private const val MENU_RECOMMEND_START = "[ "
        private const val MENU_RECOMMEND_END = " ]"
        private const val DIVISION_LINE = " | "

        private const val MENU_START = "점심 메뉴 추천을 시작합니다."
        private const val ENTER_COACHES_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)"
        private const val MENU_COACH_CANT_EAT = "(이)가 못 먹는 메뉴를 입력해 주세요."
        private const val MENU_RECOMMEND_RESULT = "메뉴 추천 결과입니다."
        private const val DAY_OF_THE_WEEK = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"
        private const val CATEGORY = "카테고리"
        private const val MENU_RECOMMEND_FINISH = "추천을 완료했습니다."
    }
}
