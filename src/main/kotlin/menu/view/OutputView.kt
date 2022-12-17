package menu.view

class OutputView {

    fun printStartMessage() {
        printMessage(START_MESSAGE)
        printEnter()
    }

    fun printInedibleFoodInputMessage(coachName: String) {
        printMessage(INEDIBLE_FOOD_INPUT_MESSAGE.format(coachName))
    }

    fun printRecommendedResultMessage(
        coaches: List<String>,
        recommendedMenuPerCoaches: HashMap<Int, LinkedHashMap<String, String>>,
    ) {
        printMessage(RECOMMENDED_MENU_MESSAGE)
        printMessage(DAY_OF_WEEKS_MESSAGE)
        printMessage(CATEGORIES_MESSAGE)
        coaches.forEach { coach ->
            val foods = arrayListOf<String>()
            for (day in 0 until WEEKDAY_SIZE) {
                foods.add(recommendedMenuPerCoaches[day]!![coach]!!)
            }
            print(foods.joinToString(" | ", "[ $coach | ", " ]\n"))
        }
        printEnter()
        printMessage(RECOMMENDED_EXIT_MESSAGE)
    }

    private fun printMessage(message: String) = println(message)

    private fun printEnter() = println()

    fun printError(error: Exception) {
        printMessage(error.message!!)
        printEnter()
    }

    companion object {
        private const val START_MESSAGE = "점심 메뉴 추천을 시작합니다."
        private const val INEDIBLE_FOOD_INPUT_MESSAGE = "%s(이)가 못 먹는 메뉴를 입력해 주세요."
        private const val RECOMMENDED_MENU_MESSAGE = "메뉴 추천 결과입니다."
        private const val DAY_OF_WEEKS_MESSAGE = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"
        private const val CATEGORIES_MESSAGE = "[ 카테고리 | 한식 | 양식 | 일식 | 중식 | 아시안 ]"
        private const val RECOMMENDED_EXIT_MESSAGE = "추천을 완료했습니다."
        private const val WEEKDAY_SIZE = 5
    }
}