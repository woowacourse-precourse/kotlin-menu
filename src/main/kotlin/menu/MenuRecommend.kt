package menu

import camp.nextstep.edu.missionutils.Randoms

class MenuRecommend {
    private val categories = listOf("일식", "한식", "중식", "아시안", "양식")
    private val japaneseMenu = listOf("규동","우동","미소시루","스시","가츠동","오니기리","하이라이스","라멘","오코노미야끼")
    private val koreanMenu = listOf("김밥","김치찌개","쌈밥","된장찌개","비빔밥","칼국수","불고기","떡볶이","제육볶음")
    private val chineseMenu = listOf("깐풍기","볶음면","동파육","짜장면","짬뽕","마파두부","탕수육","토마토 달걀볶음","고추잡채")
    private val asianMenu = listOf("팟타이","카오 팟","나시고렝","파인애플 볶음밥","쌀국수","똠얌꿍","반미","월남쌈","분짜")
    private val westernMenu = listOf("라자냐","그라탱","뇨끼","끼슈","프렌치 토스트","바게트","스파게티","피자","파니니")

    /** 1:일식, 2:한식, 3:중식, 4:아시안, 5:양식 **/
    fun pickCategory(recommendedCategory: List<String>): String {
        while (true) {
            val category: String = categories.get(Randoms.pickNumberInRange(1, 5))
            val duplicate = isCategoryDuplicated(recommendedCategory, category)
            if (!duplicate) { //겹치지않는다면 이제 메뉴를 고를 차례로 넘어간다
                return category
            }
            val numberOfCategory = countCategory(recommendedCategory, category) //몇 번 겹치는 지 확인
            if (numberOfCategory < 2) { //2회 이하로 겹친다면 이제 메뉴를 고를 차례로 넘어간다
                return category
            }
        }
    }

    private fun isCategoryDuplicated(recommendedCategory: List<String>, category: String): Boolean {
        if (recommendedCategory.contains(category)) {
            return true
        }
        return false
    }

    private fun countCategory(recommendedCategory: List<String>, category: String): Int {
        var numberOfCategory = 0
        for (categoryIndex in recommendedCategory.indices) {
            if (recommendedCategory[categoryIndex] == category) {
                numberOfCategory++
            }
        }
        return numberOfCategory
    }

    fun getSpecificMenuList(menuCategory: String): List<String>{
        if(menuCategory=="일식"){
            return japaneseMenu
        }
        if(menuCategory=="한식"){
            return koreanMenu
        }
        if(menuCategory=="중식"){
            return chineseMenu
        }
        if(menuCategory=="아시안"){
            return asianMenu
        }
        return westernMenu
    }

    fun pickMenu(category: String, coachMenu: List<String>, dislikeMenu: List<String>): String {
        val menus = getSpecificMenuList(category)
        val menu = Randoms.shuffle(menus)[0]

        return menu
    }
}