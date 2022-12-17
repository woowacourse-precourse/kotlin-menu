package menu.view

import menu.values.ErrorMessage

class InputValidator {
    fun validateCoach(input:String){
        val coaches = input.split(',')
        require(coaches.size in 2..5){ErrorMessage.COACH_NUMBER_ERROR}
        repeat(coaches.size){coach ->
            require(coaches[coach].length in 2..4){ErrorMessage.COACH_NAME_ERROR}
        }
    }

    fun validateHateMenu(input:String){
        val menu = input.split(',')
        require(menu.size in 0..2){ErrorMessage.MENU_RANGE_ERROR}
    }
}