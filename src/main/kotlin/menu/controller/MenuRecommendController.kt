package menu.controller

import menu.model.CoachGroup
import menu.model.Menu
import menu.view.View

object MenuRecommendController {
    private lateinit var coachGroup : CoachGroup

    fun startRecommendMenu(){
        View.printStartComment()
        initCoachGroup()
        Menu.initMenuDB()
        initCoachesCantEat()

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

    private fun initCoachesCantEat(){
        try {
            for (coach in coachGroup.getCoachGroup()){
                coach.setCantEat(View.requestInputCantEat(coach.getName()))
            }
        } catch (e : IllegalArgumentException){
            println(e.message)
            initCoachesCantEat()
        }
    }
}