package menu.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    // TODO : 코치 이름 입력 받을 때 예외 처리 추가해야 함
    fun getCoachNames(): List<String> {
        val names = Console.readLine()
        val coachNames = names.split(",")
        return coachNames
    }

    // TODO : 음식 입력 받을 때 예외 처리 추가해야 함
    fun getUnavailableFoods(): List<String> {
        val foods = Console.readLine()
        val foodNames = foods.split(",")
        return foodNames
    }
}