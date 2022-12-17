package menu

import camp.nextstep.edu.missionutils.Randoms

class CategoryRepository {
    private val categories: List<String> = listOf("일식", "한식", "중식", "아시안", "양식")
    private val recommendedNumber: MutableMap<String, Int> = mutableMapOf("일식" to 0, "한식" to 0, "중식" to 0, "아시안" to 0, "양식" to 0)

    private fun getRandomCategory(): String {
        return categories[Randoms.pickNumberInRange(1, 5) - 1]
    }

    fun getRecommendCategory(): String {
        var recommend = getRandomCategory()
        while(recommendedNumber[recommend] == 2) {
            recommend = getRandomCategory()
        }
        recommendedNumber[recommend] = recommendedNumber[recommend]!! + 1
        return recommend
    }
}