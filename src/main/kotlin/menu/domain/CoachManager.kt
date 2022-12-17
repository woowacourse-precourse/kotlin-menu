package menu.domain

import menu.service.Recommender
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

    private fun matchCoachFormat(coach: Coach): String {
        return Message.PrintMessage.RECOMMEND_FOOD.msg.format(
            coach.getName(),
            coach.getEatenFoods()[0],
            coach.getEatenFoods()[1],
            coach.getEatenFoods()[2],
            coach.getEatenFoods()[3],
            coach.getEatenFoods()[4],
        )
    }

    fun getCategoriesDetails(): String {
        return Message.PrintMessage.CATEGORY.msg.format(
            Message.Country.valueOf(categories[0]).value,
            Message.Country.valueOf(categories[1]).value,
            Message.Country.valueOf(categories[2]).value,
            Message.Country.valueOf(categories[3]).value,
            Message.Country.valueOf(categories[4]).value,
        )
    }

    fun getCoachesDetails(): String {
        var result = ""
        for (coach in coaches) {
            result += matchCoachFormat(coach)
            result += "\n"
        }
        return result
    }
}