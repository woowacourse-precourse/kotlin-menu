package menu

class LunchGame(
    private val inputValidator: InputValidator = InputValidator(),
    private val view: View = View(),
) {

    lateinit var coaches: List<Coach>



    fun generateCoaches(): List<Coach> {
        return getCoachesName().map { eachCoachName -> Coach(eachCoachName) }
    }

    private fun getCoachesName(): List<String> {
        val coachesName = view.inputView.requestCoachesName()

        inputValidator.validateCoaches(coachesName)

        return coachesName.split(",")
    }


}