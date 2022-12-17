package menu.controller

import camp.nextstep.edu.missionutils.Randoms
import menu.input.InputView
import menu.output.OutputView

class MenuController {
    // TODO: 전체적인 메뉴 추천 기능 진행

    private val inputView = InputView()
    private val outputView = OutputView()

    private val coaches: List<String>
    private val notEatMenus = mutableListOf<List<String>>()

    private val categories = listOf("일식", "한식", "중식", "아시안", "양식")

    private val japanMenus = listOf("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")
    private val korMenus = listOf("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")
    private val chinaMenus = listOf("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")
    private val asianMenus = listOf("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")
    private val eastMenus = listOf("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")

    private val recommendCategories= mutableListOf<String>()
    private val recommendMenus = mutableListOf<List<String>>()

    init {
        setRecommendCategory()

        outputView.startRecommendMenu()

        outputView.inputCoachName()
        coaches = inputView.inputCoachName()

        notEatMenu()

        recommendMenu()

        outputView.resultRecommendMenu()
        outputView.outputHeaderDay()
        outputView.outputCategory(recommendCategories)
        outputView.outputRecommendMenu(coaches, recommendMenus)
        outputView.outputSuccessRecommend()
    }

    private fun notEatMenu() {
        coaches.forEach {
            outputView.inputNotEatMenu(it)
            notEatMenus.add(inputView.inputNotEatMenu())
        }
    }

    private fun recommendMenu() {
        recommendCategories.forEach {
            val nowDay = mutableListOf<String>()
            for(coachIndex in coaches.indices) {
                val menu = getMenu(it, coachIndex)
                nowDay.add(menu)
            }

            recommendMenus.add(nowDay)
        }
    }

    private fun checkEatMenu(menuName: String, coachIndex: Int): Boolean {
        if(notEatMenus[coachIndex].contains(menuName))
            return true

        recommendMenus.forEach {
            if(it[coachIndex] == menuName)
                return true
        }

        return false
    }

    private fun getMenu(category: String, coachIndex: Int): String {
        var menuName = ""

        do{
            when(category) {
                "일식" -> { menuName = Randoms.shuffle(japanMenus)[0] }
                "한식" -> { menuName = Randoms.shuffle(korMenus)[0] }
                "중식" -> { menuName = Randoms.shuffle(chinaMenus)[0] }
                "아시안" -> { menuName = Randoms.shuffle(asianMenus)[0] }
                "양식" -> { menuName = Randoms.shuffle(eastMenus)[0] }
            }
        }while(checkEatMenu(menuName, coachIndex))

        return menuName
    }

    private fun setRecommendCategory() {
        for(day in 0 until 5) {
            var category = getCategory()

            while(true) {
                if(recommendCategories.count{ it == category } < 2) {
                    break
                }
                category = getCategory()
            }
            recommendCategories.add(category)
        }
    }

    private fun getCategory(): String {
        return categories[Randoms.pickNumberInRange(1, 5) - 1]
    }
}