package menu.service

import camp.nextstep.edu.missionutils.Randoms
import menu.domain.Coach

class Recommender {
    private val category = listOf("구분", "JAPAN", "KOREAN", "CHINA", "ASIAN", "WESTERN")

    // 카테고리에 해당하는 메뉴를 리스트에 저장하여 해시맵 형태로 저장
    private val menus = HashMap<String, List<String>>()

    init {
        val japanMenus = "규동,우동,미소시루,스시,가츠동,오니기리,하이라이스,라멘,오코노미야끼".split(",")
        val koreanMenus = "김밥,김치찌개,쌈밥,된장찌개,비빔밥,칼국수,불고기,떡볶이,제육볶음".split(",")
        val chinaMenus = "깐풍기,볶음면,동파육,짜장면,짬뽕,마파두부,탕수육,토마토 달걀볶음,고추잡채".split(",")
        val asianMenus = "팟타이,카오 팟,나시고렝,파인애플 볶음밥,쌀국수,똠얌꿍,반미,월남쌈,분짜".split(",")
        val westernMenus = "라자냐,그라탱,뇨끼,끼슈,프렌치 토스트,바게트,스파게티,피자,파니니".split(",")

        menus["JAPAN"] = japanMenus
        menus["KOREAN"] = koreanMenus
        menus["CHINA"] = chinaMenus
        menus["ASIAN"] = asianMenus
        menus["WESTERN"] = westernMenus
    }

    fun pickCategory(): String {
        val index = Randoms.pickNumberInRange(1, 5)
        return category[index]
    }

    /**
     * 코치가 메뉴를 이미 추천 받았거나 먹지 못하는 상태인 경우
     */
    private fun eatOrUnavailable(menu: String, coach: Coach): Boolean {
        if (coach.getEatenFoods().contains(menu)) {
            return true
        }
        if (coach.getUnavailableFoods().contains(menu)) {
            return true
        }
        return false
    }

    /**
     * 추천 받지 않았고 못 먹는 음식을 제외한 메뉴 추천
     */
    fun pickMenu(category: String, coach: Coach): String {
        var menu = Randoms.shuffle(menus[category])[0]

        while (eatOrUnavailable(menu, coach)) {
            menu = Randoms.shuffle(menus[category])[0]
        }
        return menu
    }
}