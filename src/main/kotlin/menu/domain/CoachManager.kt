package menu.domain

import menu.strings.Message

class CoachManager(
    coachNames: List<String>,
    unavailableFoods: List<List<String>>
) {
    private val coaches = mutableListOf<Coach>()
    private val recommender = Recommender()
    private val categories = mutableListOf<String>()  //  카테고리 저장

    init {
        for (i in coachNames.indices) {
            coaches.add(Coach(coachNames[i], unavailableFoods[i]))
        }
    }

    fun pickCategory() {
        do {
            val newCategory = recommender.pickCategory()
            if (categories.count { it == newCategory } < 3) {
                categories.add(newCategory)
            }
        } while (categories.size < 5)
    }

    private fun pickMenuOnce(category: String) {
        for (i in coaches.indices) {
            val menu = recommender.pickMenu(category, coaches[i])
            coaches[i].addEatenFood(menu)
        }
    }

    fun pickMenuFifth() {
        for (i in 0 until 5) {
            pickMenuOnce(categories[i])
        }
    }
}