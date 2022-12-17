package menu

import camp.nextstep.edu.missionutils.Randoms

class LunchMenuRecommender(
    private val dislikeMenus: Map<String, List<String>>,
    private val totalMenus: List<List<String>>,
    private val coaches: List<String>
) {
    private val recommendedMenu = mutableMapOf<String, MutableList<String>>()

    init {
        coaches.forEach {
            recommendedMenu[it] = mutableListOf()
        }
    }

    fun chooseOneWeekMenu(): MutableMap<String, MutableList<String>> {
        val categories = Categories()
        for (day in 0 until TOTAL_NUMBER_OF_DAYS) {
            chooseOneDayMenu(categories)
        }
        return recommendedMenu
    }

    private fun chooseOneDayMenu(categories: Categories) {
        val categoryIndex = categories.chooseCategory()
        chooseMenuForEachCoach(totalMenus[categoryIndex - 1])
    }

    private fun chooseMenuForEachCoach(categoryMenus: List<String>) {
        coaches.forEach {
            while (true) {
                val randomMenu = chooseMenu(categoryMenus)
                if (isValidMenu(it, randomMenu)) {
                    recommendedMenu[it]?.add(randomMenu)
                    break
                }
            }
        }
    }

    private fun isValidMenu(coachName: String, menuChosen: String): Boolean {
        val dislike = dislikeMenus[coachName]?.let { dislikeMenuOfThisCoach ->
            isDislikeMenu(
                dislikeMenuOfThisCoach,
                menuChosen
            )
        } ?: false
        val duplicateMenu = recommendedMenu[coachName]?.let { recommendedMenuOfThisCoach ->
            isAlreadyRecommended(
                recommendedMenuOfThisCoach,
                menuChosen
            )
        } ?: false
        return (!dislike && !duplicateMenu)
    }

    private fun isDislikeMenu(dislikeMenus: List<String>, menuChosen: String): Boolean {
        return dislikeMenus.contains(menuChosen)
    }

    private fun isAlreadyRecommended(recommendedMenus: List<String>, menuChosen: String): Boolean {
        return recommendedMenus.contains(menuChosen)
    }

    private fun chooseMenu(categoryMenus: List<String>): String {
        return Randoms.shuffle(categoryMenus)[0]
    }

    companion object {
        private const val TOTAL_NUMBER_OF_DAYS = 5
    }
}