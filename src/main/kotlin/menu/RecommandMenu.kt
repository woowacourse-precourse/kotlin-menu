package menu

class RecommandMenu {
    private var categories = CategoryRepository()
    private var menus: MutableList<MenuRepository> = mutableListOf()

    init {
        setCategories()
        setJapanMenus()
        setAsianMenus()
        setChiMenus()
        setWesternMenus()
        setKoreanMenus()
    }

    fun getCategories(): CategoryRepository {
        return categories
    }

    fun getMenus(): MutableList<MenuRepository> {
        return menus
    }

    fun setCategories() {
        categories.addLine("일식")
        categories.addLine("한식")
        categories.addLine("중식")
        categories.addLine("아시안")
        categories.addLine("양식")
    }

    fun setJapanMenus() {
        val japanFood = MenuRepository()
        japanFood.setCategory("일식")
        japanFood.addLine("규동")
        japanFood.addLine("우동")
        japanFood.addLine("미소시루")
        japanFood.addLine("스시")
        japanFood.addLine("가츠동")
        japanFood.addLine("오니기리")
        japanFood.addLine("하이라이스")
        japanFood.addLine("라멘")
        japanFood.addLine("오코노미야끼")
        menus.add(japanFood)
    }

    fun setKoreanMenus() {
        val koreanFood = MenuRepository()
        koreanFood.setCategory("한식")
        koreanFood.addLine("김밥")
        koreanFood.addLine("김치찌개")
        koreanFood.addLine("쌈밥")
        koreanFood.addLine("된장찌개")
        koreanFood.addLine("비빔밥")
        koreanFood.addLine("칼국수")
        koreanFood.addLine("불고기")
        koreanFood.addLine("떡볶이")
        koreanFood.addLine("제육볶음")
        menus.add(koreanFood)
    }

    fun setChiMenus() {
        val chiFood = MenuRepository()
        chiFood.setCategory("중식")
        chiFood.addLine("깐풍기")
        chiFood.addLine("볶음면")
        chiFood.addLine("동파육")
        chiFood.addLine("짜장면")
        chiFood.addLine("짬뽕")
        chiFood.addLine("마파두부")
        chiFood.addLine("탕수육")
        chiFood.addLine("토마토 달걀볶음")
        chiFood.addLine("고추잡채")
        menus.add(chiFood)
    }

    fun setAsianMenus() {
        val asianFood = MenuRepository()
        asianFood.setCategory("아시안")
        asianFood.addLine("팟타이")
        asianFood.addLine("카오 팟")
        asianFood.addLine("나시고렝")
        asianFood.addLine("파인애플 볶음밥")
        asianFood.addLine("쌀국수")
        asianFood.addLine("똠얌꿍")
        asianFood.addLine("반미")
        asianFood.addLine("월남쌈")
        asianFood.addLine("분짜")
        menus.add(asianFood)
    }

    fun setWesternMenus() {
        val westernFood = MenuRepository()
        westernFood.setCategory("양식")
        westernFood.addLine("라자냐")
        westernFood.addLine("그라탱")
        westernFood.addLine("뇨끼")
        westernFood.addLine("끼슈")
        westernFood.addLine("프렌치 토스트")
        westernFood.addLine("바게트")
        westernFood.addLine("스파게티")
        westernFood.addLine("피자")
        westernFood.addLine("파니니")
        menus.add(westernFood)
    }
}