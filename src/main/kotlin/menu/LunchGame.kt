package menu

import camp.nextstep.edu.missionutils.Randoms

class LunchGame(
    //TODO : PRIVATE 멤버로 바꾸기
    val recommendationMachine: RecommendationMachine = RecommendationMachine(),
    private val inputValidator: InputValidator = InputValidator(),
    private val view: View = View(),
) {

    //TODO : PRIVATE 멤버로 바꾸기
    lateinit var coaches: List<Coach>

    fun play(){
        initCoaches()
    }

    fun initCoaches() {
        coaches = getCoachesName().map { eachCoachName -> Coach(eachCoachName) }
    }

    private fun getCoachesName(): List<String> {
        val coachesName = view.inputView.requestCoachesName()

        inputValidator.validateCoaches(coachesName)

        return coachesName.split(",")
    }

    fun initHatingMenusToEachCoach() {
        coaches.forEach { eachCoach ->
            val hatingMenus = getHatingMenusName(eachCoach.name)
                .map { eachMenuName -> eachMenuName }

            eachCoach.setHatingMenus(hatingMenus)
        }
    }

    private fun getHatingMenusName(coachName: String): List<String> {
        val hatingMenus = view.inputView.requestHatingMenus(coachName)

        inputValidator.validateHatingMenu(hatingMenus)

        return hatingMenus.split(",")
    }

    fun recommendMenus() {
        recommendationMachine.initThisWeekCategories()

        coaches.forEach { eachCoach ->
            recommendationMachine.recommendMenu(eachCoach)
        }
    }
}