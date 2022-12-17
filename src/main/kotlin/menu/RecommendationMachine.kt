package menu

import camp.nextstep.edu.missionutils.Randoms
import menu.CategoryAndMenu.menus
import java.awt.Menu

class RecommendationMachine {
    //TODO : private
    var thisWeekCategories = arrayListOf<Int>()

    fun initThisWeekCategories() {
        var categoryCnt = 0

        while (categoryCnt < 7) {
            val chosenCategory = Randoms.pickNumberInRange(1, 5)
            if (thisWeekCategories.count { category -> category == chosenCategory } < 2) {
                categoryCnt++
                thisWeekCategories.add(chosenCategory)
            }
        }
    }

    fun recommendMenu(eachCoach: Coach) {
        thisWeekCategories.forEach { categoryNum ->
            var isRecommended = false

            while (!isRecommended) {
                val randomMenu = Randoms.shuffle(menus[categoryNum])[0]
                isRecommended = eachCoach.selectMyMenu(randomMenu)
            }
        }
    }
}