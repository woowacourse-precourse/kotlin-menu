package menu

import camp.nextstep.edu.missionutils.Randoms

class LunchMenuRecommender(
    private val dislikeMenus: Map<String, List<String>>,
    private val totalMenus: List<List<String>>,
    private val coaches: List<String>
) {
    private val recommendedMenu = mutableMapOf<String, MutableList<String>>()
    private val categoryChosen = mutableListOf<Int>()

    init {
        coaches.forEach {
            recommendedMenu[it] = mutableListOf()
        }
    }

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

    private fun chooseMenuForEachCoach(categoryMenus: List<String>) {
        coaches.forEach {
            while (true) {
                val randomMenu = chooseMenu(categoryMenus)
                // 못 먹는 메뉴인지 체크
                val dislike = false
                // 중복된 메뉴인지 체크
                val duplicateMenu = false
                if (!dislike && !duplicateMenu) {
                    recommendedMenu[it]?.add(randomMenu)
                }
            }
        }
    }

    private fun chooseMenu(categoryMenus: List<String>): String {
        return Randoms.shuffle(categoryMenus)[0]
    }
}