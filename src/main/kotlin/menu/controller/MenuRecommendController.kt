package menu.controller

import menu.model.CoachGroup
import menu.view.View

object MenuRecommendController {
    private lateinit var coachGroup : CoachGroup

    fun startRecommendMenu(){
        View.printStartComment()
        initCoachGroup()
    }

    private fun initCoachGroup(){
        try {
            val coachNames = View.requestInputCoachName()
            coachGroup = CoachGroup(coachNames)
        } catch (e : IllegalArgumentException){
            println(e.message)
            initCoachGroup()
        }
    }
}