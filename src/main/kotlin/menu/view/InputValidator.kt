package menu.view

import menu.values.ErrorMessage

class InputValidator {
    fun validateCoach(input: String) {
        require(input != ""){"[ERROR] 공백을 입력할 수 없습니다."}
        require(input[0] != ',' && input[input.length-1] !=','){ErrorMessage.NOT_COMMA_FRONT_BACK}
        val coaches = input.split(',')
        require(coaches.size in 2..5) { ErrorMessage.COACH_NUMBER_ERROR }
        repeat(coaches.size) { coach ->
            require(coaches[coach].length in 2..4) { ErrorMessage.COACH_NAME_ERROR }
        }
    }

    fun validateHateMenu(input: String) {
        if(input != "") {
            require(input[0] != ',' && input[input.length - 1] != ',') { ErrorMessage.NOT_COMMA_FRONT_BACK }
        }
        val menu = input.split(',')
        require(menu.size in 0..2) { ErrorMessage.MENU_RANGE_ERROR }
        require(menu.toSet().size == menu.size){ErrorMessage.NOT_REPEAT}
    }
}