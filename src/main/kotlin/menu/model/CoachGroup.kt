package menu.model

import menu.exceptions.ValidateBusinessLogic

class CoachGroup(coachGroupNames: String) {

    private val coachGroup = mutableListOf<Coach>()

    init {
        val tempCoachGroup = coachGroupNames.split(",")
        ValidateBusinessLogic.validateCoachHeadCount(tempCoachGroup.size)
        initCoachGroup(tempCoachGroup)
    }

    private fun initCoachGroup(tempCoachGroup: List<String>) {
        for (tempCoach in tempCoachGroup) {
            coachGroup.add(Coach(tempCoach))
        }
    }

    fun getCoachGroup() = coachGroup.toList()
}