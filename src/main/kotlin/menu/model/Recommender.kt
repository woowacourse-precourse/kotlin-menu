package menu.model

import camp.nextstep.edu.missionutils.Randoms

// 카테고리 당 나온 횟수를 저장하고 있으며
// 이미 2번 나온 카테고리를 다시 추천할 경우 다시 정한다.
// 정해진 카테고리에 해당하는 메뉴를 랜덤으로 코치들에게 배정
// 해당 메뉴가 못먹는 메뉴인지 판단하여 그렇다면 다시 배정하는 기능
// 해당 메뉴가 이미 먹은 메뉴인지 판단하여 그렇다면 다시 배정하는 기능
class Recommender(private val coach: List<String>, private val banFood: MutableList<List<String>>) {
    private val japan = Menu.JAPAN
    private val korean = Menu.KOREAN
    private val china = Menu.CHINA
    private val asian = Menu.ASIAN
    private val western = Menu.WESTERN
    private val menu = listOf<Menu>(japan, korean, china, asian, western)
    private val categoryCounter = mutableListOf<Int>(0, 0, 0, 0, 0)
    private val eatingMenu = mutableListOf<MutableList<String>>()

    init {
        for (index in coach.indices) {
            eatingMenu.add(mutableListOf<String>())
        }
    }

    fun selectCategory(categoryNumber: Int): Flag {
        if (categoryCounter[categoryNumber] == 2) {
            return Flag.FAIL
        }
        return Flag.PASS
    }

    fun getCategory(categoryNumber: Int): Menu {
        categoryCounter[categoryNumber]++
        return menu[categoryNumber]
    }

    fun selectMenu(category: Menu): List<String> {
        val menuList = mutableListOf<String>()
        var todayMenu: String
        for (index in coach.indices) {
            do {
                todayMenu = Randoms.shuffle(category.menu)[0]
                val flag1 = validateEating(todayMenu, index)
                val flag2 = validateBan(todayMenu, index)
            } while (flag1 == Flag.FAIL || flag2 == Flag.FAIL)
            menuList.add(todayMenu)
            eatingMenu[index].add(todayMenu)
        }
        return menuList.toList()
    }

    private fun validateEating(menu: String, index: Int): Flag {
        if (eatingMenu[index].contains(menu)) {
            return Flag.FAIL
        }
        return Flag.PASS
    }

    private fun validateBan(menu: String, index: Int): Flag {
        if (banFood[index].contains(menu)) {
            return Flag.FAIL
        }
        return Flag.PASS
    }

}