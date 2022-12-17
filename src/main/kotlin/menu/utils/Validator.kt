package menu.utils

import menu.utils.ErrorMessage.COACH_COUNT_ERROR_MESSAGE
import menu.utils.ErrorMessage.COACH_DUPLICATION_ERROR_MESSAGE
import menu.utils.ErrorMessage.COACH_NAME_LENGTH_ERROR_MESSAGE
import menu.utils.ErrorMessage.HATE_MENUS_COUNT_ERROR_MESSAGE
import menu.utils.ErrorMessage.HATE_MENUS_DUPLICATION_ERROR_MESSAGE
import menu.utils.ErrorMessage.HATE_MENUS_EXIST_ERROR_MESSAGE

object Validator {
    private val menuList = listOf(
        "규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼",
        "김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음",
        "깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채",
        "팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜",
        "라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"
    )

    fun checkCoachesValid(input: String) {
        checkCoachesCount(input)
        checkCoachesDuplication(input)
    }

    private fun checkCoachesCount(input: String) {
        val size = input.split(',').size
        require(size in 2..5) { COACH_COUNT_ERROR_MESSAGE }
    }

    private fun checkCoachesDuplication(input: String) {
        val coaches = input.split(',')
        val distinctCoaches = coaches.distinct()
        require(coaches.size == distinctCoaches.size) { COACH_DUPLICATION_ERROR_MESSAGE }
    }

    fun checkCoachNameValid(input: String) {
        require(input.length in 2..4) { COACH_NAME_LENGTH_ERROR_MESSAGE }
    }

    fun checkHateMenusSize(input: String) {
        val menus = input.split(',')
        require(menus.size in 0..2) { HATE_MENUS_COUNT_ERROR_MESSAGE }
    }

    fun checkHateMenusValid(hateMenus: List<String>) {
        checkHateMenusDuplication(hateMenus)
        checkHateMenusExist(hateMenus)
    }

    private fun checkHateMenusDuplication(hateMenus: List<String>) {
        val distinct = hateMenus.distinct()
        require(hateMenus.size == distinct.size) { HATE_MENUS_DUPLICATION_ERROR_MESSAGE }
    }

    private fun checkHateMenusExist(hateMenus: List<String>) {
        hateMenus.forEach { require(it in menuList) { HATE_MENUS_EXIST_ERROR_MESSAGE } }
    }
}