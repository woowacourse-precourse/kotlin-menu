package menu.domain

import menu.utils.Constant.ASIAN_NAME
import menu.utils.Constant.ASIAN_NUMBER
import menu.utils.Constant.CHINESE_NAME
import menu.utils.Constant.CHINESE_NUMBER
import menu.utils.Constant.JAPANESE_NAME
import menu.utils.Constant.JAPANESE_NUMBER
import menu.utils.Constant.KOREAN_NAME
import menu.utils.Constant.KOREAN_NUMBER
import menu.utils.Constant.WESTERN_NAME
import menu.utils.Constant.WESTERN_NUMBER

enum class Category(
    private val categoryName: String,
    private val categoryNumber: Int,
    private val menus: List<String>
) {
    JAPANESE(JAPANESE_NAME, JAPANESE_NUMBER, listOf("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREAN(KOREAN_NAME, KOREAN_NUMBER, listOf("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINESE(CHINESE_NAME, CHINESE_NUMBER, listOf("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIAN(ASIAN_NAME, ASIAN_NUMBER, listOf("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WESTERN(WESTERN_NAME, WESTERN_NUMBER, listOf("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    companion object {
        fun getCategoryName(number: Int): String = values().find { it.categoryNumber == number }!!.categoryName
        fun isMenuExist(menu: String): Boolean = values().find { it.menus.contains(menu) } != null
        fun getMenuList(categoryName: String): List<String> = values().find { it.categoryName == categoryName }!!.menus
    }
}