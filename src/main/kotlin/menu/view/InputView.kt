package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.service.ExceptionHandler

class InputView {
    fun getCoachNames(): List<String> {
        var names = ""
        do{
            names = Console.readLine().trim()
        }while(!ExceptionHandler.isValidNameLength(names)
            || !ExceptionHandler.isValidNumber(names.split(",").size))

        return names.split(",")
    }

    // TODO : 음식 입력 받을 때 예외 처리 추가해야 함
    fun getUnavailableFoods(): List<String> {
        val foods = Console.readLine()
        val foodNames = foods.split(",")
        return foodNames
    }
}