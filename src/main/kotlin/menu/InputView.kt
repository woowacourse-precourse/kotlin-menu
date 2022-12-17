package menu

import camp.nextstep.edu.missionutils.Console

class InputView(val checker: ValidChecker = ValidChecker()) {

    fun inputCoachName(): List<String> {
        val coachNames: String
        val names: List<String>
        println("코치의 이름을 입력해 주세요. (, 로 구분)")
        try {
            coachNames = Console.readLine()
            names = checker.checkCoachNames(coachNames)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return inputCoachName()
        }
        return names
    }

    fun inputHateFood(name: String): List<String> {
        val hateFood: String
        val hateFoods: List<String>
        println("${name}(이)가 못 먹는 메뉴를 입력해 주세요.")
        try {
            hateFood = Console.readLine()
            hateFoods = checker.checkHateFood(hateFood)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return inputHateFood(name)
        }
        return hateFoods
    }
}