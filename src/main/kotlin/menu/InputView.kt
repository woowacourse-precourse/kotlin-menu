package menu

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun inputCoaches(): List<String>{
        println(INPUT_COACH_NAME)
        var userInput = Console.readLine()
        while (!Validator.isValidCoachInput(userInput)) {
            println(IllegalArgumentException(INPUT_COACH_NAME_COUNT_ERROR_MESSAGE))
            println(INPUT_COACH_NAME)
            userInput = Console.readLine()
        }
        return userInput.split(',')
    }

    fun inputCoachNotEat(coaches: List<String>) {
        for (c in coaches) {
            println(c + COACH_NOT_EAT)
            var userInput = Console.readLine()
            while (!Validator.isValidCoachNotEat(userInput)) {
                println(IllegalArgumentException(INPUT_COACH_NOT_EAT_ERROR_MESSAGE))
                println(c + COACH_NOT_EAT)
                userInput = Console.readLine()
            }
        }
    }



    companion object {
        const val INPUT_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)"
        const val INPUT_COACH_NAME_COUNT_ERROR_MESSAGE = "[ERROR] 코치는 2~5명 까지 입력 가능하고, 코치의 이름은 2~4개의 글자여야 하며, ','로만 구분할 수 있어야 합니다."
        const val COACH_NOT_EAT = "(이)가 못 먹는 메뉴를 입력해 주세요."
        const val INPUT_COACH_NOT_EAT_ERROR_MESSAGE = "[ERROR] 코치는 0~2개 까지 못 먹는 메뉴가 있고, 먹지 못하는 메뉴가 없으면 빈 값을 입력하며, ','로만 구분할 수 있어야 합니다."

    }


}