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
        val categoryIndex = chooseCategory()
        chooseMenu(totalMenus[categoryIndex])
    }

    private fun chooseCategory(): Int {
        val randomNumber = Randoms.pickNumberInRange(1, 5)
        if (categoryChosen.count { it == randomNumber } == 2) {
            chooseCategory()
        }
        categoryChosen.add(randomNumber)
        return randomNumber
    }

    private fun chooseMenu(categoryMenus: List<String>) {

    }
}