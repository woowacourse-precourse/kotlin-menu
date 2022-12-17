package menu.controller

import menu.model.Category
import menu.model.CoachGroup
import menu.model.Menu
import menu.view.View

object MenuRecommendController {
    private lateinit var coachGroup: CoachGroup

    fun startRecommendMenu() {
        View.printStartComment()
        initCoachGroup()
        Menu.initMenuDB()
        initCoachesCantEat()
        Category.initRecommendCategories()
        initRecommendMenuForCoaches()
        View.printResultRecommendedMenu(coachGroup)
    }

    private fun initCoachGroup() {
        try {
            val coachNames = View.requestInputCoachName()
            coachGroup = CoachGroup(coachNames)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            initCoachGroup()
        }
    }

    private fun initCoachesCantEat() {
        try {
            for (coach in coachGroup.getCoachGroup()) {
                coach.setCantEat(View.requestInputCantEat(coach.getName()))
            }
        } catch (e: IllegalArgumentException) {
            println(e.message)
            initCoachesCantEat()
        }
    }

    private fun initRecommendMenuForCoaches() {
        for (coach in coachGroup.getCoachGroup()) {
            val pickedCategories = Category.getRecommendCategories()
            for (category in pickedCategories) {
                coach.initRecommendedMenus(category)
            }
        }
    }
}