package menu.model

import camp.nextstep.edu.missionutils.Randoms

object Category {

    private const val MENUS = """일식: 규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼
    한식: 김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음
    중식: 깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채
    아시안: 팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜
    양식: 라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니"""
    private const val MAX_RECOMMEND_COUNT = 2
    private const val MAX_RECOMMENDED_CATEGORIES_SIZE = 5

    private val recommendedCategories = mutableListOf<String>()

    // 추천 카테고리를 반환 ex) 한식,양식,일식,중식,중식
    fun getRecommendCategories() = recommendedCategories

    fun initRecommendCategories(): List<String> {
        while (recommendedCategories.size < MAX_RECOMMENDED_CATEGORIES_SIZE) {
            val pickedCategory = getRandomPickedRecommendCategory(getCategories())
            if (recommendedCategories.count { it == pickedCategory } == MAX_RECOMMEND_COUNT) {
                continue
            }
            recommendedCategories.add(pickedCategory)
        }
        return recommendedCategories.toList()
    }

    fun getCategories(): List<String> {
        val tempMenus = MENUS.split("\n")
        val categories = mutableListOf<String>()

        for (menu in tempMenus) {
            val category = menu.split(":")
            categories.add(category[0].trimIndent())
        }
        return categories
    }

    private fun getRandomPickedRecommendCategory(categories: List<String>): String {
        return categories[Randoms.pickNumberInRange(1, 5) - 1]
    }

}