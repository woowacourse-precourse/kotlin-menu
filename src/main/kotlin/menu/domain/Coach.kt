package menu.domain

import menu.utils.Validator.checkCoachNameValid

class Coach(private val name : String) {
    init {
        checkCoachNameValid(name)
    }
}