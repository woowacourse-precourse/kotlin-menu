package menu.domain

import menu.utils.Validator.checkCoachNameValid
import menu.utils.Validator.checkHateMenusValid

class Coach(private val coachName: String, private val hateMenus: List<String>) {
    private val menus = mutableListOf<String>()

    init {
        checkCoachNameValid(coachName)
        checkHateMenusValid(hateMenus)
    }

    fun containHateMenus(menu: String): Boolean = hateMenus.contains(menu)

    fun getCoachName() = coachName

    fun addMenu(menu: String) {
        this.menus.add(menu)
    }

    fun getMenus() = this.menus

    fun containMenu(menu: String) = menus.contains(menu)
}