package menu

import camp.nextstep.edu.missionutils.Randoms

class LunchMenuRecommender(
    private val dislikeMenus: Map<String, List<String>>,
    private val totalMenus: List<List<String>>
) {
    private val recommendedMenu = mutableMapOf<String, List<String>>()
    private val categoryChosen = mutableListOf<Int>()

    fun chooseOneWeekMenu() {

    }

    private fun chooseOneDayMenu() {
        val randomNumber = Randoms.pickNumberInRange(1, 5)
        if (categoryChosen.count { it.equals(randomNumber) } == 2) {
            chooseOneDayMenu()
        }
        chooseCategory(totalMenus[randomNumber])
    }

    private fun chooseCategory(categoryMenus: List<String>) {

    }

    private fun chooseMenu() {

    }
}