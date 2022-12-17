package menu.domain

import menu.utils.Validator.checkCoachNameValid
import menu.utils.Validator.checkHateMenusDuplication

class Coach(private val coachName: String, private val hateMenus: List<String>) {
    init {
        checkCoachNameValid(coachName)
        checkHateMenusDuplication(hateMenus)
    }
}