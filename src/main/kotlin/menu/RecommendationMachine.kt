package menu

import camp.nextstep.edu.missionutils.Randoms
import menu.CategoryAndMenu.menus
import java.awt.Menu

class RecommendationMachine {
    //TODO : private
    var thisWeekCategories = arrayListOf<Int>()

    //TODO : 메소드 길이 줄이기
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
            val randomMenu = Randoms.shuffle(menus[categoryNum])[0]
            var isRecommended = false

            while (!isRecommended) {
                isRecommended = eachCoach.selectMyMenu(randomMenu)
            }
        }
    }
}