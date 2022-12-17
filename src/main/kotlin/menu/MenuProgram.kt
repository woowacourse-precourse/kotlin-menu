package menu

import camp.nextstep.edu.missionutils.Randoms

class MenuProgram(val input: InputView, val output: OutputView) {

    private val coachs: MutableList<Coach>
    private val categories: Categories
    private val categoryOfDay = Categories(mutableListOf()) //요일별 카테고리


    init {
        val japan = Category(1, "일식", listOf("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"))
        val korea = Category(2, "한식", listOf("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"))
        val china = Category(3, "중식", listOf("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"))
        val asia = Category(4, "아시안", listOf("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"))
        val west = Category(5, "양식", listOf("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"))
        categories = Categories(mutableListOf(japan, korea, china, asia, west))
        coachs = mutableListOf()
    }

    fun runProgram() {
        output.printStart()
        makeCoaches()
        findHateFood()
        setMenu()
        output.printResult(categoryOfDay.getCategoryData(), coachs)
    }

    private fun makeCoaches() {
        val coach = input.inputCoachName()
        for (each in coach) {
            coachs.add(Coach(each, mutableListOf()))
        }
    }

    private fun findHateFood() {
        var hateFood: List<String>
        for (coach in coachs) {
            hateFood = input.inputHateFood(coach.name).toMutableList()
            coach.hateFood = hateFood
        }
    }

    private fun pickCategory(): Category {
        var pick: Int
        while (true) {
            pick = Randoms.pickNumberInRange(1, 5)
            if (categories.checkCategoryCount(pick)) break
        }

        return categories.getCategoryByIndex(pick) //해당 카테고리 반환
    }

    private fun makeMenu(menus: List<String>, coach: Coach) {

        var menu: String = Randoms.shuffle(menus)[0]

        while (coach.checkCantEat(menu)) {
            menu = Randoms.shuffle(menus)[0]
        }
        coach.foodToEat.add(menu)
    }

    private fun setMenu() {
        for (day in 0 until 5) {
            categoryOfDay.add(pickCategory())
            for (coach in coachs) {
                makeMenu(categoryOfDay.getLastCategoryMenus(day), coach)
            }
        }
    }

}