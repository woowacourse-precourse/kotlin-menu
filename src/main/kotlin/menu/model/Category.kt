package menu.model

enum class Category(val categoryName: String, val number: Int, val menus: List<Menu>) {
    JAPANESE_FOOD("일식", 1, "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼".split(",").map { Menu(it.trim()) }),
    KOREAN_FOOD("한식", 2, "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음".split(",").map { Menu(it.trim()) }),
    CHINESE_FOOD("중식", 3, "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채".split(",").map { Menu(it.trim()) }),
    ASIAN_FOOD("아시안", 4, "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜".split(",").map { Menu(it.trim()) }),
    WESTERN_FOOD("양식", 5, "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니".split(",").map { Menu(it.trim()) });

    fun containMenu(menu: Menu): Boolean = this.menus.contains(menu)
}