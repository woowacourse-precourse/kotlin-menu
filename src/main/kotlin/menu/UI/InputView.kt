package menu.UI

import camp.nextstep.edu.missionutils.Console
import menu.Coach
import menu.Exception

class InputView {
    fun coachName() : List<String>{
        var coachNames = listOf<String>()
        try {
            println("코치의 이름을 입력해 주세요. (, 로 구분)")
            coachNames = Console.readLine().split(",")
            Exception().coachException(coachNames)
        }catch (e : IllegalArgumentException){
            println(e.message)
            return coachName()
        }
        return coachNames
    }

    fun hateFood(coach: Coach) : List<String>{
        var hateFoods = listOf<String>()
        try {
            println("${coach.getName()}(이)가 못 먹는 메뉴를 입력해 주세요.")
            hateFoods = Console.readLine().split(",")
            Exception().hateFoodException(hateFoods)
        }catch (e: IllegalArgumentException){
            println(e.message)
            return hateFood(coach)
        }
        return hateFoods
    }
}