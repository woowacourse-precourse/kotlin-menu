package menu

class LunchGame(
    private val inputValidator: InputValidator = InputValidator(),
    private val view: View = View(),
) {

    lateinit var coaches: List<Coach>

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
                .map { eachMenuName -> Menu(eachMenuName) }

            eachCoach.setHatingMenus(hatingMenus)
        }
    }

    private fun getHatingMenusName(coachName: String): List<String> {
        val hatingMenus = view.inputView.requestHatingMenus(coachName)

        inputValidator.validateHatingMenu(hatingMenus)

        return hatingMenus.split(",")
    }


}