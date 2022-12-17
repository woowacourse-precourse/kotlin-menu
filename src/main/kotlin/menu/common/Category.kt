package menu.common

import camp.nextstep.edu.missionutils.Randoms

enum class Category(val order: Int, val category: String, val menus: List<String>) {
    JAPANESE(1, "일식", listOf("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREAN(2, "한식", listOf("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINESE(3, "중식", listOf("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIAN(4, "아시안", listOf("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WESTERN(5, "양식", listOf("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    companion object {
        private const val CATEGORY_ERROR = "카테고리 선택에서 예상치 못한 오류가 발생했습니다."
        fun isMenuExist(menu: String): Boolean {
            values().forEach {
                if (menu in it.menus) {
                    return true
                }
            }
            return false
        }

        fun getRandomCategory(): Category {
            val randomNumber = Randoms.pickNumberInRange(1, 5)
            return values()
                .find { it.order == randomNumber }
                ?: throw IllegalArgumentException(CATEGORY_ERROR)
        }
    }
}
