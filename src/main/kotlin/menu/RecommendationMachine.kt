package menu

import camp.nextstep.edu.missionutils.Randoms
import menu.FoodData.categoryToMenus

class RecommendationMachine {
    var thisWeekCategories = arrayListOf<Int>()

    fun recommendTodayMenu(coaches: List<Coach>) {
        val todaysCategory = thisWeekCategories.last()

        coaches.forEach { eachCoach ->
            var isRecommended = false

            while (!isRecommended) {
                val randomMenu = Randoms.shuffle(todaysCategory.categoryToMenus())[0]
                isRecommended = eachCoach.selectMyMenu(randomMenu)
            }
        }
    }

    fun selectTodayCategory() {
        var isChosen = false

        while (!isChosen) {
            val chosenCategory = Randoms.pickNumberInRange(1, 5)

            if (thisWeekCategories.count { category -> category == chosenCategory } < 2) {
                isChosen = true
                thisWeekCategories.add(chosenCategory)
            }
        }
    }
}