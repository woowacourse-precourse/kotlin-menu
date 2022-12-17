package menu

import camp.nextstep.edu.missionutils.Randoms

class SuggestionMenu {

    init {
        allMenus.add(mutableListOf<String>())
        for (i in 1..HIGH_CATEGORY) {
            when (i) {
                Category.JAPANESE_FOOD.index -> allMenus.add(japanMenus.split(",").map { it.trim() }.toMutableList())
                Category.KOREAN_FOOD.index -> allMenus.add(koreanMenus.split(",").map { it.trim() }.toMutableList())
                Category.CHINESE_FOOD.index -> allMenus.add(chineseMenus.split(",").map { it.trim() }.toMutableList())
                Category.ASIAN_FOOD.index -> allMenus.add(asianMenus.split(",").map { it.trim() }.toMutableList())
                Category.WESTERN_FOOD.index -> allMenus.add(westernMenus.split(",").map { it.trim() }.toMutableList())
            }
        }
    }

    fun suggestionMenus(coaches: List<Coach>): List<Category> {
        val choiceCategories = mutableListOf<Category>()
        for (nowDay in 0 until HIGH_DAY) {
            val nowDayCategory = suggestionCategory(choiceCategories)
            choiceCategories.add(nowDayCategory)
            coaches.forEach { suggestionEachMenu(nowDayCategory, it) }
        }
        return choiceCategories
    }

    private fun suggestionCategory(choiceCategory: List<Category>): Category {
        val randomCategory = Randoms.pickNumberInRange(LOW_CATEGORY, HIGH_CATEGORY)
        val category = FindCategoryByValue.fromValue(randomCategory)
        var count = 0
        choiceCategory.forEach { // 중복 카테고리는 최대 두 개만 허용한다.
            if (category == it) count++
        }
        return if (count >= MAX_DUPLICATE_CATEGORY)
            suggestionCategory(choiceCategory)
        else
            return category!!
    }

    private fun suggestionEachMenu(choiceCategory: Category, coach: Coach) {
        while (true) {
            val menu: String = Randoms.shuffle(allMenus[choiceCategory.index])[0]
            if (coach.menus.find { it == menu } != null || menu in coach.hateEatMenus) {
                continue
            }
            coach.menus.add(menu)
            break
        }
    }

    fun getAllMenus(): List<List<String>> = allMenus.map { it.toList() }.toList()

    companion object {
        private val allMenus = mutableListOf<MutableList<String>>()
        private const val japanMenus = "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼"
        private const val koreanMenus = "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음"
        private const val chineseMenus = "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채"
        private const val asianMenus = "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜"
        private const val westernMenus = "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니"

        const val LOW_CATEGORY = 1
        const val HIGH_CATEGORY = 5
        const val HIGH_DAY = 5
        private const val MAX_DUPLICATE_CATEGORY = 2
    }
}