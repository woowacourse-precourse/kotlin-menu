package menu

import camp.nextstep.edu.missionutils.Randoms
import menu.view.InputView
import menu.view.OutputView

class MenuMission(private val inputView: InputView, private val outputView: OutputView) {

    val JAPAN = listOf("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")
    val KOREA = listOf("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")
    val CHINA = listOf("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")
    val ASIAN = listOf("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")
    val WEST = listOf("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")

    /*메뉴를 추천하는 과정은 아래와 같이 이뤄진다.
    월요일에 추천할 카테고리를 무작위로 정한다.
    각 코치가 월요일에 먹을 메뉴를 추천한다.
    화, 수, 목, 금요일에 대해 i, ii 과정을 반복한다.*/
    fun missionStart() {
        val coaches = coachCheck(inputView.getCoach())
        val coachesHateFoods = coachHateFood(coaches)
        var recommendFood = mutableMapOf<String, MutableList<String>>()//이름 별 음식 저장
        var day = 0
        val categories = mutableListOf<Int>()
        while (day != 5) {
            val category: Int = (Randoms.pickNumberInRange(1, 5))//    월요일에 추천할 카테고리를 무작위로 정한다.
            //카테고리 예외
            //menu 예외
            coaches.forEach {
                val menu: String = Randoms.shuffle(getFood(category))[0]//    각 코치가 월요일에 먹을 메뉴를 추천한다.
                if(recommendFood[it]==null){
                    recommendFood[it]= mutableListOf()
                }
                recommendFood[it]?.add(menu)
            }
            categories.add(category)
            day++
        }
        outputView.printCategories(categories)
        outputView.printRecommendMenu(coaches, recommendFood)
        outputView.printEnd()
    }

    fun recommendCoachs(coaches: List<String>, category: Int): MutableMap<String, MutableList<String>> {
        val recommendFood = mutableMapOf<String, MutableList<String>>()
        coaches.forEach {
            val menu: String = Randoms.shuffle(getFood(category))[0]//    각 코치가 월요일에 먹을 메뉴를 추천한다.
            if(recommendFood[it]==null){
                recommendFood[it]= mutableListOf()
            }
            recommendFood[it]?.add(menu)
        }
        return recommendFood
    }

    fun getFood(pickNumberInRange: Int): List<String> {
        return when (pickNumberInRange) {
            1 -> JAPAN
            2 -> KOREA
            3 -> CHINA
            4 -> ASIAN
            else -> WEST
        }
    }


    // 입력 체크...
    fun coachHateFood(coaches: List<String>): Map<String, List<String>> {
        val coachHate = mutableMapOf<String, List<String>>()
        coaches.forEach {
            val hates = hateFoodCheck(inputView.getHateFood(it))
            coachHate[it] = hates
        }
        return coachHate
    }


    fun coachCheck(coach: String): List<String> {//coach 따로 클래스 만들어서 구현
        val coaches = coach.split(",")
        coaches.forEach {
            if (it.length !in 2..4)
                throw IllegalArgumentException(ERROR_COACH_NAME_SIZE_MESSAGE)
        }
        if (coaches.size < 2)
            throw IllegalArgumentException(ERROR_COACHES_MIN_MESSAGE)
        if (coaches.size > 5)
            throw IllegalArgumentException(ERROR_COACHES_MAX_MESSAGE)
        return coaches
    }

    fun hateFoodCheck(hateFood: String): List<String> {
        val hates = hateFood.split(",")
        if (hates.size > 2)
            throw IllegalArgumentException(ERROR_COACHES_MIN_MESSAGE)
        return hates
    }
}