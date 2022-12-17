package menu.view

class ViewValidate {

    fun coachNamesForm(input: String) {
        val names = input.split(",")
        names.forEach { name ->
            require(COACH_NAMES_FORM.toRegex().matches(name)) { println("[ERROR] 코치의 이름은 2글자 부터 4명글자 까지 입력해야 합니다.") }
        }
        require((2..5).contains(names.size)) { println("[ERROR] 코치는 최소 2명 부터 최대 5명 까지만 입력해주세요.") }
    }

    fun excludedFoodsForm(input: String) {
        val foods = input.split(",")
        foods.forEach { food ->
            require(allFood().contains(food) || food=="")
        }
        require((0..2).contains(foods.size)) { println("[ERROR] 못먹는 음식은 2개 이하만 입력해주세요.") }
        require(foods.size==foods.distinct().size) { println("[ERROR] 못먹는 음식을 중복 없이 입력해주세요.")}
    }

    fun japaneseFood() = "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼".split(", ")

    fun koreanFood() = "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음".split(", ")

    fun chineseFood() = "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채".split(", ")

    fun asianFood() = "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜".split(", ")

    fun westernFood() = "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니".split(", ")

    fun allFood() = japaneseFood()+koreanFood()+chineseFood()+asianFood()+westernFood()

    companion object {
        private const val COACH_NAMES_FORM = "^.{2,4}\$"
    }
}