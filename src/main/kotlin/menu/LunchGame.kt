package menu

import camp.nextstep.edu.missionutils.Randoms

class LunchGame(
    private val inputValidator: InputValidator = InputValidator(),
    private val view: View = View(),
) {

    //TODO : PRIVATE 멤버로 바꾸기
    lateinit var coaches: List<Coach>
    var thisWeekCategories = arrayListOf<Int>()

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

    fun initThisWeekCategories() {
        val categoriesRecord = IntArray(6) { 0 }
        var categoryCnt = 0

        while (categoryCnt < 7) {
            val chosenCategory = Randoms.pickNumberInRange(1, 5)

            if (categoriesRecord[chosenCategory] != 2) {
                categoryCnt++
                categoriesRecord[chosenCategory]++
                thisWeekCategories.add(chosenCategory)
            }
        }
    }

}