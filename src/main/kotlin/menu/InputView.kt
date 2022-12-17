package menu

import camp.nextstep.edu.missionutils.Console

class InputView {


    fun inputCoach(): String{
        var userInput = Console.readLine()
        while (!Validator.isValidCoachInput(userInput)) {
            println(IllegalArgumentException(INPUT_COACH_ERROR_MESSAGE))
            userInput = Console.readLine()
        }
        return userInput
    }



    companion object {
        const val INPUT_COACH_ERROR_MESSAGE = "[ERROR] 코치는 2~5명 까지 입력 가능하고, 코치의 이름은 2~4개의 글자여야 합니다."
    }


}