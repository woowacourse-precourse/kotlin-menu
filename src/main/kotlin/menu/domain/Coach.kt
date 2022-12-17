package menu.domain

import menu.utils.Validator.checkCoachNameValid
import menu.utils.Validator.checkHateMenusValid

class Coach(private val coachName: String, private val hateMenus: List<String>) {
    init {
        checkCoachNameValid(coachName)
        checkHateMenusValid(hateMenus)
    }

    fun containHateMenus(menu: String): Boolean = hateMenus.contains(menu)
}